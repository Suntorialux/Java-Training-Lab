/**
 * 
 */
package by.epam;

import java.util.TimerTask;

/**
 * This class is task for car.
 * 
 * 
 * @author Andrei Yahorau
 *
 */
public class TaskDisqualify extends TimerTask {

	private Car car;
	
	/**
	 * @param car is car
	 */
	public TaskDisqualify(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		car.disqualify();
	}

}
