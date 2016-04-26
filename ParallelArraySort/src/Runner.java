
import java.util.Arrays;
import java.util.Random;

import mySort.SortThread;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int threads = Runtime.getRuntime().availableProcessors();

		Random rand = new Random();
		final int[] values = new int[10000000];
		for (int i = 0; i < values.length; i++) {
			values[i] = rand.nextInt();
		}

		// print(values);

		long start = System.currentTimeMillis();

		int middle = values.length / 2;
		int[] left = Arrays.copyOfRange(values, 0, middle);
		int[] right = Arrays.copyOfRange(values, middle, values.length);

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

		int[] finishArray = merge(left, right);

		long end = System.currentTimeMillis();

		System.out.println("Sort two thread: " + (end - start));

		// print(finishArray);

		start = System.currentTimeMillis();

		Arrays.sort(values);

		end = System.currentTimeMillis();
		System.out.println("Sort one thread: " + (end - start));

	}

	/*
	 * private static void print (int [] array) { for(int value : array) {
	 * System.out.print(value+" "); } System.out.println(""); }
	 * 
	 */

	private static int[] merge(int[] arr_1, int[] arr_2) {
		int len_1 = arr_1.length, len_2 = arr_2.length;
		int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
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
