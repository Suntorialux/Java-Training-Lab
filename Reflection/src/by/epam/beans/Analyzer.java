/**
 * 
 */
package by.epam.beans;

import java.lang.reflect.Field;
import by.epam.annotation.CompareBy;
import by.epam.annotation.Equal;

/**
 * @author Andrei Yahorau
 *
 */
public class Analyzer {

	public static boolean equalObjects(Object obj1, Object obj2)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Class<?> class1 = obj1.getClass();
		Class<?> class2 = obj2.getClass();
		Field[] fields1 = class1.getDeclaredFields();
		if (fields1.length != 0) {
			for (Field field : fields1) {
				if (field.isAnnotationPresent(Equal.class)) {
					Field field2 = class2.getDeclaredField(field.getName());
					field.setAccessible(true);
					field2.setAccessible(true);
					CompareBy compareBy = field.getAnnotation(Equal.class).value();
					System.out.println("The name of the field is "+field.getName()+"");
					System.out.println("Have annotation "+ Equal.class.getSimpleName() + " with value " + compareBy);
					switch (compareBy) {
					case REFERANCE: {
						if (field.get(obj1) != field2.get(obj2)) {
							return false;
						}
						break;
					}
					case VALUE: {
						if (!(field.get(obj1).equals(field2.get(obj2)))) {
							return false;
						}
						break;
					}
					}
				}
			}
			return true;
		}
		return false;
	}
}
