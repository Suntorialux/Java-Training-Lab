/**
 * 
 */
package by.epam;


import java.util.concurrent.SynchronousQueue;

/**
 * @author Andrei
 *
 */
public class Pensil extends Thread {

	private SynchronousQueue<Integer> queue;
	private int iteration;

	/**
	 * @param queue
	 * @param iteration
	 */
	public Pensil(SynchronousQueue<Integer> queue, int iteration) {
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
				queue.put(i);
				System.out.println("Drawing..." + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
