import java.text.ParseException;

import javax.xml.transform.TransformerException;

import beans.Flight;
import util.FlightsDOMBuilder;

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

		try {
			FlightsDOMBuilder builder = new FlightsDOMBuilder();
			builder.biuldListFlights("src/AirlineShedule.xml");
			
			for (Flight flight : builder.getShedule()) {
				System.out.println(flight);
			}

			builder.exportSheduleToXML("src/shedule.xml", builder.getShedule());
			
		} catch (TransformerException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
