import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.dec2020.model.Payment;
import com.smoothstack.dec2020.service.BookingService;
import com.smoothstack.dec2020.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@RequestMapping(path = "payment/create/{bookingId}", method = RequestMethod.POST)
	public Payment createPayment(@PathVariable int bookingId)
	{
		return paymentService.createPayment(bookingId);
	}

	@RequestMapping(path = "payment/refund/{paymentId}", method = RequestMethod.DELETE)
	public Payment refundPayment(@PathVariable int paymentId)
	{
		return paymentService.refundPayment(paymentId);
	}

}
