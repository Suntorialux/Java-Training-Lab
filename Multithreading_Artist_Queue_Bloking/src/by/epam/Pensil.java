/**
 * 
 */
package by.epam;


import java.util.concurrent.BlockingQueue;


/**
 * @author Andrei Yahorau
 *
 */
public class Pensil extends Thread {

	private final BlockingQueue<Integer> queue;
	private int iteration;

	/**
	 * @param queue
	 * @param iteration
	 */
	public Pensil(BlockingQueue<Integer> queue, int iteration) {
		this.queue = queue;
		this.iteration = iteration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.iteration; i++) {
			try {
				System.out.println("Drawing..." + i);
				queue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
