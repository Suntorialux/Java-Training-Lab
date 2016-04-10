/**
 * 
 */
package by.epam;

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
		Artist artist = new Artist();
		Pencil pencil = new Pencil(artist, 5);
		Eraser eraser = new Eraser(artist);
		pencil.start();
		eraser.start();
	}

}
