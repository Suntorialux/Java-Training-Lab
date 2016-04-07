import by.epam.LFUCache;

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
		LFUCache<Integer, Integer> cache = new LFUCache<Integer, Integer>(10, 0.1f);
		for (int i = 0; i < 11; i++) {
			cache.put(i, i);
		}
	}

}
