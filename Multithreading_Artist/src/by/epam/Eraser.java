/**
 * 
 */
package by.epam;

/**
 * @author Andrei Yahorau
 *
 */
public class Eraser extends Thread {
	private Artist artist;

	// private int iteration;
	/**
	 * @param artist
	 */
	public Eraser(Artist artist) {
		super();
		this.artist = artist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		int i = 0;
		while (artist.erase().equals("Drawing...")) {
			System.out.println("Erasing..."+ i++);
			

		}

	}

}
