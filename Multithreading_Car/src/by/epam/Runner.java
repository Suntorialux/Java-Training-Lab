/**
 * 
 */
package by.epam;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Andrei Yahorau
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Car ferrari = new Car("Ferrari", 50);
		Car maserati = new Car("Maserati", 70);
		Car bmv = new Car("BMV", 60);
		Car mercedes = new Car("Mercedes", 50);
		Car lada = new Car("Lada", 500);
		
		new Timer().schedule(new TaskDisqualify(ferrari), 5000);
		new Timer().schedule(new TaskDisqualify(lada), 5000);
		
		exec.execute(ferrari);
		exec.execute(maserati);
		exec.execute(bmv);
		exec.execute(mercedes);
		exec.execute(lada);
			
		exec.shutdown();
	}

}
