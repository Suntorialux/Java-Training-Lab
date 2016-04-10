/**
 * 
 */
package by.epam;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Andrei
 *
 */
public class Artist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronousQueue<Integer> paper = new SynchronousQueue<>();
		
		Pensil pensil = new Pensil(paper, 5);
		Eraser eraser = new Eraser(paper);
		pensil.start();
		eraser.start();
		
	}

}
