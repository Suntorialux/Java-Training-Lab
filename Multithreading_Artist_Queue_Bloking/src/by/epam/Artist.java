/**
 * 
 */
package by.epam;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author Andrei Yahorau
 *
 */
public class Artist {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> paper = new LinkedBlockingQueue<>(1);
		Pensil pensil = new Pensil(paper, 5);
		Eraser eraser = new Eraser(paper);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(pensil);
		exec.execute(eraser);
		
	}
}
