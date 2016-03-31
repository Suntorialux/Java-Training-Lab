/**
 * 
 */
package by.epam.beans;

import by.epam.annotation.CompareBy;
import by.epam.annotation.Equal;

/**
 * @author Andrei Yahorau
 *
 */
public class Person {

	@Equal(CompareBy.REFERANCE)
	private String name;

	@Equal(CompareBy.VALUE)
	private int age;
	
	@Equal(CompareBy.REFERANCE)
	private int weight;

	/**
	 * @param name
	 * @param age
	 * @param weight
	 */
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	
}
