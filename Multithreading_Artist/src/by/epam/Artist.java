/**
 * 
 */
package by.epam;

/**
 * @author Andrei Yahorau
 *
 */
public class Artist {
	private String content = null;
	private boolean empty = true;

	public synchronized String erase() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = true;
		notifyAll();
		return content;
	}

	public synchronized void draw(String content) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = false;
		this.content = content;
		notifyAll();
	}
}
