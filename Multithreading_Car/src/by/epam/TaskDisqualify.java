/**
 * 
 */
package by.epam;

import java.util.TimerTask;

/**
 * @author Andrei Yahorau
 *
 */
public class TaskDisqualify extends TimerTask {

	private Car car;
	
	/**
	 * @param car
	 */
	public TaskDisqualify(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		car.disqualy();
	}

}
