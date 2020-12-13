package deadlock;

/**
 * @author F. Ulstak
 * hit 4-5 times to produce a deadlock
 */

class Balls
{
    public static long balls = 0;
}

// Hold the number of runs scored so far
class Runs
{
    public static long runs = 0;
}

class Count implements Runnable
{
    // increment runs variable then increments balls
    public void IncrAfterRun()
    {
        synchronized(Runs.class)
        {
            synchronized(Balls.class)
            {
                Runs.runs++;
                Balls.balls++;
            }
        }
    }

    // vice versa
    public void IncAfterBall()
    {
        synchronized(Balls.class)
        {
            synchronized(Runs.class)
            {
                Balls.balls++;
                Runs.runs++;
            }
        }
    }

    public void run()
    {
        IncrAfterRun();
        IncAfterBall();
    }

}

public class Deadlock
{
    public static void main(String[] args) throws InterruptedException
    {
        Count count = new Count();
        Thread t1 = new Thread(count);
        Thread t2 = new Thread(count);
        t1.start();
        t2.start();
        System.out.println("Waiting for threads to complete execution. . .");
        t2.join();
        t2.join();
        System.out.println("Done.");    }
}
