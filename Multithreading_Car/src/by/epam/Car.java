/**
 * 
 */
package by.epam;

import java.util.logging.Logger;

/**
 * @author Andrei Yahorau
 *
 */
public class Car implements Runnable {

	private static final long MAX_DISTANCE = 10000;
	Logger log = Logger.getLogger(getClass().toString());
	private long friction;
	private long distance;
	private String name;
	private static volatile boolean available = true;
	private volatile boolean stop = false;

	public Car(String name, long friction) {
		this.name = name;
		this.friction = friction;
	}

	public void disqualy() {
		this.stop = true;
	}

	@Override
	public void run() {
		try {
			while (!stop && distance < MAX_DISTANCE) {
				Thread.sleep(friction);
				distance += 100;
				log.info(name + " " + distance);
			}

			synchronized (this) {
				if (!stop && available) {
					System.out.println("Winner is " + name);
					available = false;
				}
				if (stop) {
					System.out.println(name + " is disqualify!!!");
				}
			}
			
		} catch (InterruptedException e) {
			log.info(e.getMessage());
		}
	}
}
