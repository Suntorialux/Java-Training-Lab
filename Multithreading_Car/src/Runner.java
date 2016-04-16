/**
 * 
 */

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import by.epam.Car;
import by.epam.TaskDisqualify;

/**
 * @author Andrei Yahorau
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		ExecutorService exec = Executors.newCachedThreadPool();

		// Created cars
		
		Car ferrari = new Car("Ferrari", 50);
		Car maserati = new Car("Maserati", 70);
		Car bmv = new Car("BMV", 60);
		Car mercedes = new Car("Mercedes", 50);
		Car lada = new Car("Lada", 500);

		// Set timer and task
		
		new Timer(true).schedule(new TaskDisqualify(ferrari), 5000);
		new Timer(true).schedule(new TaskDisqualify(lada), 5000);

		// execute new runnable
		
		exec.execute(ferrari);
		exec.execute(maserati);
		exec.execute(bmv);
		exec.execute(mercedes);
		exec.execute(lada);
		
		shutdownAndAwaitTermination(exec);
		
	}
	
	/** The method shuts down an ExecutorService in two phases, 
	*   first by calling shutdown to reject incoming tasks, and then calling shutdownNow,
	*   if necessary, to cancel any lingering tasks
	*/
	static void shutdownAndAwaitTermination(ExecutorService pool) {
		   pool.shutdown(); // Disable new tasks from being submitted
		   try {
		     // Wait a while for existing tasks to terminate
		     if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
		       pool.shutdownNow(); // Cancel currently executing tasks
		       // Wait a while for tasks to respond to being cancelled
		       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
		           System.err.println("Pool did not terminate");
		     }
		   } catch (InterruptedException ie) {
		     // (Re-)Cancel if current thread also interrupted
		     pool.shutdownNow();
		     // Preserve interrupt status
		     Thread.currentThread().interrupt();
		   }
		 }

}
