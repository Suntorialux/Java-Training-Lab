/**
 * 
 */
package by.epam;

import java.util.concurrent.BlockingQueue;


/**
 * @author Andrei Yahorau
 *
 */
public class Eraser extends Thread {

	private final BlockingQueue<Integer> queue;

	/**
	 * @param queue
	 */
	public Eraser(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				int i = queue.take();
				System.out.println("Erasing..." + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
