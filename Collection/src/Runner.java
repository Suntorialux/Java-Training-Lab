import java.util.Scanner;

/**
 * 
 */

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
		String text = "qwe qwe QWE ER ERWE TRET RETER fsdf  dfdf er ree er er";
		System.out.print("Enter the word: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int quantity = Analizator.frequencyWord(word, text);
		System.out.println("The word " + word + " is found " + quantity + " times.");

	}

}
