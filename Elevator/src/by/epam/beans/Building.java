package by.epam.beans;

import java.util.List;

public class Building {
	
	/** The list of floor */ 
	private List<Floor> floors;
	
	/** Count of persons completed the move */
	private volatile int countMovedPerson; 
	
	/**
	 * 
	 * @param floors
	 */
	public Building(List<Floor> floors) {
		this.floors = floors;
		this.countMovedPerson = 0;
	}
	
	/**
	 * @return the floors
	 */
	public List<Floor> getFloors() {
		return floors;
	}

	/**
	 * 
	 * @param floors
	 */
	public void setFloors(List<Floor> floors){
		this.floors = floors;
	}
	
	/**
	 * 
	 * @return countMovedPerson
	 */
	public int getCountMovedPerson() {
		return countMovedPerson;
	}

	/**
	 * 
	 * @param countMovedPerson
	 */
	public void setCountMovedPerson(int countMovedPerson) {
		this.countMovedPerson = countMovedPerson;
	}

	/**
	 * 
	 */
	public synchronized void personArrive(){
		countMovedPerson++;
	}

}
