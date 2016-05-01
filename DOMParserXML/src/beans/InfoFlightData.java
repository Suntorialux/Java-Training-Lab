/**
 * 
 */
package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrei Yahorau
 *
 */
public class InfoFlightData {

	private final static DateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private final static DateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private final static DateFormat INPUT_TIME_FORMAT = new SimpleDateFormat("HH:mm");
	private final static DateFormat OUTPUT_TIME_FORMAT = new SimpleDateFormat("HH:mm");

	private String country;
	private String city;
	private String airport;
	private String terminal;
	private String gate;
	private Date date;
	private Date time;

	/**
	 * 
	 */
	public InfoFlightData() {
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the airport
	 */
	public String getAirport() {
		return airport;
	}

	/**
	 * @param airport
	 *            the airport to set
	 */
	public void setAirport(String airport) {
		this.airport = airport;
	}

	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the gate
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * @param gate
	 *            the gate to set
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @return the String date
	 */
	public String getStringDate() {
		return OUTPUT_DATE_FORMAT.format(date);
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		try {
			this.date = INPUT_DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * 
	 * @return the String time
	 */
	public String getStringTime() {
		return OUTPUT_TIME_FORMAT.format(time);
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * 
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		try {
			this.time = INPUT_TIME_FORMAT.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [country=" + country + ", city=" + city + ", airport=" + airport + ", terminal="
				+ terminal + ", gate=" + gate + ", date=" + getStringDate() + ", time=" + getStringTime() + "]";
	}
}
