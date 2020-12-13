package dec11ProdCons;

/**
 * @author F. Ulstak
 * producer and consumer w/ sync queue
 */ 

import java.util.Random;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class Dec11
{
    Deque<String> queue = new LinkedBlockingDeque<String>();
    String[] weather = { "Sunny", "Showers", "Thunderstorm", "Snow", "Cloudy"};
    Random rand = new Random();

    class Producer extends Thread
    {

        public void run()
        {
            while (true)
            {
                queue.add(weather[rand.nextInt(weather.length)]);
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException ie)
                {
                    // ignore it
                }
            }
        }
    }

    class Consumer extends Thread
    {
        int processedWeather = 0;
        public void run()
        {
            while(processedWeather < 20)
            {
                while (queue.isEmpty())
                {
                    /*wait till an entry is inserted*/
                }
                
                System.out.println(queue.remove());
                processedWeather++;
            }
            
            System.out.println("exited OK");
            System.exit(0);
        }
    }
    
    public static void main(String[] args)
    {
        Dec11 blocking = new Dec11();
        blocking.new Producer().start();
        blocking.new Consumer().start();
    }
}
