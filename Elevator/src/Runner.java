import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.epam.beans.Building;
import by.epam.beans.Elevator;
import by.epam.beans.Floor;
import by.epam.beans.Person;
import by.epam.util.Controller;

public class Runner {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final int NUMBER_OF_PERSONS = 5;
		final int NUMBER_OF_FLOORS = 10;
		final int ELEVATOR_CAPACITY = 2;
		
		/** Create the building, elevator, passengers and floors */
		Elevator elevator = new Elevator(ELEVATOR_CAPACITY);
		List<Person> persons = new ArrayList<>();
		List<Floor> floors = new ArrayList<>();
		Building building = new Building(floors);
		
		/** Initialization passengers */
		Random random = new Random();
		for (int i = 0; i < NUMBER_OF_PERSONS; i++) {
			int startFloor = random.nextInt(NUMBER_OF_FLOORS - 1) + 1;
			int arrivalFloor = random.nextInt(NUMBER_OF_FLOORS - 1) + 1;
			while (arrivalFloor == startFloor) {
				arrivalFloor = random.nextInt(NUMBER_OF_FLOORS - 1) + 1;
			}
			persons.add(new Person(i + 1, building, startFloor, arrivalFloor));
		}

		/** Initialization floors */
		for (int i = 0; i < NUMBER_OF_FLOORS; i++) {
			floors.add(new Floor(i + 1, elevator));
		}
		
		/** Create controller */
		Controller controller = new Controller(elevator, building, floors, persons);
		Thread test = new Thread(controller);
		
		/** Start elevator */
		test.start();

		try {
			test.join();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

}
