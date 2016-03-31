import by.epam.beans.Analyzer;
import by.epam.beans.Person;

/**
 * 
 */

/**
 * @author Andrei Yahorau
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("Mike", 20, 70);
		Person person2 = new Person("Mat", 20, 67);
		try {
			boolean isEqual = Analyzer.equalObjects(person1, person2);
			System.out.println("The objects is "+(isEqual?"equals" : "not equals"));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
