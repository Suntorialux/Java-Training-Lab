package mySort;

import java.util.Arrays;

public class SortThread extends Thread {

	private int[] values;

	/**
	 * @param values
	 */
	public SortThread(int[] values) {
		this.values = values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Arrays.sort(values);
	}

	/**
	 * @return the values
	 */
	public int[] getValues() {
		return values;
	}

}
