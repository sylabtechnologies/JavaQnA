import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smoothstack.dec2020.model.Booking;

@RestController
public class TimerController {

	@Value("${booking.url}")
	String bookingUrl;

	final static int MAX_BUCKETS = 60;
	final static int MAX_DELTA = 10; // we got 10 seconds, waiting 10 minutes
	final static Duration delta = Duration.ofSeconds(MAX_DELTA);

	// call this from admin background process with negative id
	// to setup ping mode to cleanup, each 10 minutes
	static volatile boolean pingMode;

	static LinkedBlockingDeque<ArrayList<Integer>> buckets;
	static LinkedBlockingDeque<LocalTime> times;

	@RequestMapping(path = "timer/{bookingId}", method = RequestMethod.POST)
	public void addBooking(@PathVariable int bookingId) {

		LocalTime time = LocalTime.now();

		if (bookingId < 0)
			pingMode = true;
		else
			pingMode = false;

		long numBuckets = times.getLast().until(time, SECONDS) / MAX_DELTA;

		if (numBuckets > 0)
			for (int i = 0; i < numBuckets; i++)
			{
				buckets.add(new ArrayList<Integer>());
				LocalTime nextTime = times.getLast().plus(delta);
				times.add(nextTime);

				if (buckets.size() > MAX_BUCKETS)
					prune(buckets.removeFirst());
			}

		if (!pingMode)
			buckets.getLast().add(bookingId);
	}

	private void prune(ArrayList<Integer> bucket) {
		for (int i = 0; i < bucket.size(); i++)
		{
			RestTemplate req = new RestTemplate();
			ResponseEntity<Booking> response =
				req.getForEntity(bookingUrl + "/" + bucket.get(i), Booking.class);

			if (response.getStatusCode() != HttpStatus.OK)
				continue;

			req.put(bookingUrl + "/inactive/" + response.getBody().getId(), " ");
		}
	}

	@PostConstruct
	private void init() {
		buckets = new LinkedBlockingDeque<>();
		buckets.add(new ArrayList<Integer>());
		times.add(LocalTime.now());
	}

}
