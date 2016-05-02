package by.epam.beans;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	/** The number of floor */
	private int floorNumber;

	/** The elevator */
	private final Elevator elevator;

	/** The list is waited passengers */
	private List<Person> waitingPersons;

	/** The list is arrived passengers */
	private List<Person> arivvedPersons;

	/**
	 * 
	 * @param floorNumber
	 * @param waitingPersons
	 * @param elevator
	 */
	public Floor(int floorNumber, List<Person> waitingPersons, Elevator elevator) {
		this.floorNumber = floorNumber;
		this.waitingPersons = waitingPersons;
		this.elevator = elevator;
		this.arivvedPersons = new ArrayList<>();
	}

	/**
	 * 
	 * @param floorNumber
	 * @param elevator
	 */
	public Floor(int floorNumber, Elevator elevator) {
		this.floorNumber = floorNumber;
		this.waitingPersons = new ArrayList<>();
		this.elevator = elevator;
		this.arivvedPersons = new ArrayList<>();
	}

	/**
	 * 
	 * @param person
	 */
	public void addPersonToFloor(Person person) {
		waitingPersons.add(person);
	}

	/**
	 * Awakens all the threads of a particular floor
	 */
	public synchronized void wakeUp() {
		notifyAll();
	}

	/**
	 * The passengers move to elevator
	 * 
	 * @param person
	 */
	public synchronized void moveToElevator(Person person) {

		if (floorNumber != elevator.getCurrentFloor() || elevator.isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!elevator.isFull() || waitingPersons.size() == 0) {
			System.out.println("Passenger " + person.getPersonId() + " go into elevator on " + floorNumber + " floor");
			elevator.addToElevator(waitingPersons.get(waitingPersons.indexOf(person)));
			waitingPersons.remove(person);
		} else {
			moveToElevator(person);
		}

	}

	/**
	 * The passengers leave the elevator
	 * 
	 * @param person
	 */
	public synchronized void goOutFromElevator(Person person) {
		if ((elevator.getCurrentFloor() + 1) != person.getArrivalFloor()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elevator.removeFromElevator(person);
		arivvedPersons.add(person);
		System.out.println("Passenger " + person.getPersonId() + " go out on " + floorNumber + " floor");
	}
}
