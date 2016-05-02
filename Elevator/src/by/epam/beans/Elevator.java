package by.epam.beans;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	/** The current floor where stop elevator */
	private volatile int currentFloor;

	/** The list of passenger */
	private volatile List<Person> persons;

	/** The capacity of elevator */
	private int capacity;

	/**
	 * 
	 * @param capacity
	 */
	public Elevator(int capacity) {
		this.capacity = capacity;
		persons = new ArrayList<>(capacity);
		this.currentFloor = 1;
	}

	/**
	 * 
	 * @return current floor
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}

	/**
	 * 
	 * @param person
	 */
	public void addToElevator(Person person) {
		if (!isFull()) {
			persons.add(person);
		}
	}

	/**
	 * 
	 * @return list of person
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * Delete person from elevator
	 * 
	 * @param person
	 */
	public void removeFromElevator(Person person) {
		persons.remove(person);
	}

	/**
	 * 
	 * @return full elevator or not full
	 */
	public boolean isFull() {
		boolean isFull = false;
		if (capacity == persons.size()) {
			isFull = true;
		}
		return isFull;
	}

	/**
	 * 
	 * @param currentFloor
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

}
