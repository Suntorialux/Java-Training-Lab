/**
 * 
 */
package by.epam;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author Andrei Yahorau
 *
 */
public class Artist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> paper = new LinkedBlockingQueue<>();
		
		Pensil pensil = new Pensil(paper, 5);
		Eraser eraser = new Eraser(paper);
		pensil.start();
		eraser.start();
		
	}

}
