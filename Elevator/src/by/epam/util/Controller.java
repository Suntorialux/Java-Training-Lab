package by.epam.util;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.epam.beans.Building;
import by.epam.beans.Elevator;
import by.epam.beans.Floor;
import by.epam.beans.Person;

public class Controller implements Runnable {

	/** The elevator */
	private final Elevator elevator;
	
	/** The building */
	private final Building building;
	
	/** The list of floors */
	private List<Floor> floors;
	
	/** The list of passengers */
	private List<Person> persons;

	private final int NUMBER_OF_PERSONS = 5;
	private final int NUMBER_OF_FLOORS = 10;
	
	/**
	 * 
	 * @param elevator
	 * @param building
	 * @param floors
	 * @param persons
	 */
	public Controller(Elevator elevator, Building building, List<Floor> floors, List<Person> persons) {
		this.floors = floors;
		this.persons = persons;
		this.elevator = elevator;
		this.building = building;
		initializationFloors(this.floors, persons);
		building.setFloors(this.floors);
	}

	/** Placement of people on floors */
	private void initializationFloors(List<Floor> floors, List<Person> persons) {
		int numberFloor = 0;
		for (int i = 0; i < persons.size(); i++) {
			numberFloor = persons.get(i).getStartFloor() - 1;
			floors.get(numberFloor).addPersonToFloor(persons.get(i));
		}
	}

	@Override
	public void run() {

		ExecutorService exec = Executors.newCachedThreadPool();
		for (Person person : persons) {
			exec.execute(person);
		}
		exec.shutdown();
		
		int max = NUMBER_OF_FLOORS;
		int index = 1;
		int start = 0;
		
		for (int i = start; index * i < max - start; i = i + 1 * index) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			elevator.setCurrentFloor(i);
			if (building.getCountMovedPerson() == NUMBER_OF_PERSONS) {
				System.out.println("----------------------------------");
				System.out.println("Transportatiton finished");
				break;
			}
			System.out.println("-------------------------------------");
			System.out.println("Elevator on floor " + (elevator.getCurrentFloor() + 1));

			building.getFloors().get(elevator.getCurrentFloor()).wakeUp();
			if (i == max - 1 || (i == 0 && index == -1)) {
				index *= -1;
				start = i;
			}

		}
	}
}
