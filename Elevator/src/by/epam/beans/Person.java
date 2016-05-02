package by.epam.beans;

public class Person extends Thread {

	/** id passenger */
	private final int id;

	/** The floor where passenger enter into elevator */
	private int startFloor;

	/** The floor where the passenger gets off the elevator */
	private int arrivalFloor;

	/** The building */
	private Building building;

	/**
	 * 
	 * @param id
	 *            person
	 * @param building
	 * @param startFloor
	 * @param arrivalFloor
	 */
	public Person(int id, Building building, int startFloor, int arrivalFloor) {
		this.id = id;
		this.building = building;
		this.startFloor = startFloor;
		this.arrivalFloor = arrivalFloor;
	}

	/**
	 * 
	 * @return arrivalFloor
	 */
	public int getArrivalFloor() {
		return arrivalFloor;
	}

	/**
	 * 
	 * @return id person
	 */
	public int getPersonId() {
		return id;
	}

	/**
	 * 
	 * @return startFloor
	 */
	public int getStartFloor() {
		return startFloor;
	}

	
	@Override
	public void run() {
		
		building.getFloors().get(startFloor-1).moveToElevator(this);
		building.getFloors().get(arrivalFloor-1).goOutFromElevator(this);
		building.personArrive();
	}

}
