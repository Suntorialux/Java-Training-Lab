/**
 * 
 */
package by.epam;

/**
 * @author Andrei Yahorau
 *
 */
public class Pencil extends Thread {
	private Artist artist;
	private int iteration;
		
	/**
	 * @param artist
	 * @param iteration
	 */
	public Pencil(Artist artist, int iteration) {
		this.artist = artist;
		this.iteration = iteration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < this.iteration ; i++) {
			System.out.println("Drawing..."+i);
			artist.draw("Drawing...");
		}
		artist.draw("DONE");
	}
	
	
	
}
