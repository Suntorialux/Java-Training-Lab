
import java.util.Arrays;
import java.util.Random;

import by.epam.SortThread;

public class Runner {

	public static void main(String[] args) {

		// We create an array and fill it with randomly

		Random rand = new Random();
		int[] values = new int[10000000];
		for (int i = 0; i < values.length; i++) {
			values[i] = rand.nextInt();
		}

		// Make a timestamp
		long start = System.currentTimeMillis();

		// Divide the array into two
		int middle = values.length / 2;
		int[] left = Arrays.copyOfRange(values, 0, middle);
		int[] right = Arrays.copyOfRange(values, middle, values.length);

		// Sort arrays
		SortThread thread1 = new SortThread(left);
		SortThread thread2 = new SortThread(right);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Merge two arrays in one
		merge(left, right);

		long end = System.currentTimeMillis();

		// Print the time of sorting two thread
		System.out.println("Sort two thread: " + (end - start));

		// Sort one thread
		start = System.currentTimeMillis();

		Arrays.sort(values);

		end = System.currentTimeMillis();

		// Print the time of sorting one thread
		System.out.println("Sort one thread: " + (end - start));

	}

	// method merge two array in one
	private static int[] merge(int[] arr_1, int[] arr_2) {
		int len_1 = arr_1.length, len_2 = arr_2.length;
		int a = 0, b = 0, len = len_1 + len_2;
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			if (b < len_2 && a < len_1) {
				if (arr_1[a] > arr_2[b])
					result[i] = arr_2[b++];
				else
					result[i] = arr_1[a++];
			} else if (b < len_2) {
				result[i] = arr_2[b++];
			} else {
				result[i] = arr_1[a++];
			}
		}
		return result;
	}

}
