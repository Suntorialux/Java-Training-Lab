/**
 * 
 */
package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrei Yahorau
 *
 */
public class Flight {

	private final static DateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	
	private String numberFlight;
	private String numberAircraft;
	private String typeAircraft;
	private String modelAircraft;
	private String countryOfDeparture;
	private String cityOfDeparture;
	private String airportOfDeparture;
	private String terminalOfDeparture;
	private String gateOfDeparture;
	private Date dateOfDeparture;
	private String timeOfDeparture;
	private String countryOfArrival;
	private String cityOfArrival;
	private String airportOfArrival;
	private String terminalOfArrival;
	private String gateOfArrival;
	private Date dateOfArrival;
	private String timeOfArrival;

	/**
	 * 
	 */
	public Flight() {
	}

	/**
	 * @return the numberFlight
	 */
	public String getNumberFlight() {
		return numberFlight;
	}

	/**
	 * @param numberFlight
	 *            the numberFlight to set
	 */
	public void setNumberFlight(String numberFlight) {
		this.numberFlight = numberFlight;
	}

	/**
	 * @return the numberAircraft
	 */
	public String getNumberAircraft() {
		return numberAircraft;
	}

	/**
	 * @param numberAircraft
	 *            the numberAircraft to set
	 */
	public void setNumberAircraft(String numberAircraft) {
		this.numberAircraft = numberAircraft;
	}

	/**
	 * @return the typeAircraft
	 */
	public String getTypeAircraft() {
		return typeAircraft;
	}

	/**
	 * @param typeAircraft
	 *            the typeAircraft to set
	 */
	public void setTypeAircraft(String typeAircraft) {
		this.typeAircraft = typeAircraft;
	}

	/**
	 * @return the modelAircraft
	 */
	public String getModelAircraft() {
		return modelAircraft;
	}

	/**
	 * @param modelAircraft
	 *            the modelAircraft to set
	 */
	public void setModelAircraft(String modelAircraft) {
		this.modelAircraft = modelAircraft;
	}

	/**
	 * @return the countryOfDeparture
	 */
	public String getCountryOfDeparture() {
		return countryOfDeparture;
	}

	/**
	 * @param countryOfDeparture
	 *            the countryOfDeparture to set
	 */
	public void setCountryOfDeparture(String countryOfDeparture) {
		this.countryOfDeparture = countryOfDeparture;
	}

	/**
	 * @return the cityOfDeparture
	 */
	public String getCityOfDeparture() {
		return cityOfDeparture;
	}

	/**
	 * @param cityOfDeparture
	 *            the cityOfDeparture to set
	 */
	public void setCityOfDeparture(String cityOfDeparture) {
		this.cityOfDeparture = cityOfDeparture;
	}

	/**
	 * @return the airportOfDeparture
	 */
	public String getAirportOfDeparture() {
		return airportOfDeparture;
	}

	/**
	 * @param airportOfDeparture
	 *            the airportOfDeparture to set
	 */
	public void setAirportOfDeparture(String airportOfDeparture) {
		this.airportOfDeparture = airportOfDeparture;
	}

	/**
	 * @return the terminalOfDeparture
	 */
	public String getTerminalOfDeparture() {
		return terminalOfDeparture;
	}

	/**
	 * @param terminalOfDeparture
	 *            the terminalOfDeparture to set
	 */
	public void setTerminalOfDeparture(String terminalOfDeparture) {
		this.terminalOfDeparture = terminalOfDeparture;
	}

	/**
	 * @return the dateOfDeparture
	 */
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	/**
	 * @param dateOfDeparture
	 *            the dateOfDeparture to set
	 */
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	/**
	 * @return the timeOfDeparture
	 */
	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}

	/**
	 * @param timeOfDeparture
	 *            the timeOfDeparture to set
	 */
	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}

	/**
	 * @return the countryOfArrival
	 */
	public String getCountryOfArrival() {
		return countryOfArrival;
	}

	/**
	 * @param countryOfArrival
	 *            the countryOfArrival to set
	 */
	public void setCountryOfArrival(String countryOfArrival) {
		this.countryOfArrival = countryOfArrival;
	}

	/**
	 * @return the cityOfArrival
	 */
	public String getCityOfArrival() {
		return cityOfArrival;
	}

	/**
	 * @param cityOfArrival
	 *            the cityOfArrival to set
	 */
	public void setCityOfArrival(String cityOfArrival) {
		this.cityOfArrival = cityOfArrival;
	}

	/**
	 * @return the airportOfArrival
	 */
	public String getAirportOfArrival() {
		return airportOfArrival;
	}

	/**
	 * @param airportOfArrival
	 *            the airportOfArrival to set
	 */
	public void setAirportOfArrival(String airportOfArrival) {
		this.airportOfArrival = airportOfArrival;
	}

	/**
	 * @return the terminalOfArrival
	 */
	public String getTerminalOfArrival() {
		return terminalOfArrival;
	}

	/**
	 * @param terminalOfArrival
	 *            the terminalOfArrival to set
	 */
	public void setTerminalOfArrival(String terminalOfArrival) {
		this.terminalOfArrival = terminalOfArrival;
	}

	/**
	 * @return the dateOfArrival
	 */
	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	/**
	 * @param dateOfArrival
	 *            the dateOfArrival to set
	 */
	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	/**
	 * @return the timeOfArrival
	 */
	public String getTimeOfArrival() {
		return timeOfArrival;
	}

	/**
	 * @param timeOfArrival
	 *            the timeOfArrival to set
	 */
	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	/**
	 * @return the gateOfDeparture
	 */
	public String getGateOfDeparture() {
		return gateOfDeparture;
	}

	/**
	 * @param gateOfDeparture
	 *            the gateOfDeparture to set
	 */
	public void setGateOfDeparture(String gateOfDeparture) {
		this.gateOfDeparture = gateOfDeparture;
	}

	/**
	 * @return the gateOfArrival
	 */
	public String getGateOfArrival() {
		return gateOfArrival;
	}

	/**
	 * @param gateOfArrival
	 *            the gateOfArrival to set
	 */
	public void setGateOfArrival(String gateOfArrival) {
		this.gateOfArrival = gateOfArrival;
	}
	

	public String getStringDateOfDeparture () {
		return OUTPUT_DATE_FORMAT.format(dateOfDeparture);
	}
	
	

	public String getStringDateOfArrival () {
		return OUTPUT_DATE_FORMAT.format(dateOfArrival);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [numberFlight=" + numberFlight + ", numberAircraft=" + numberAircraft + ", typeAircraft="
				+ typeAircraft + ", modelAircraft=" + modelAircraft + ", countryOfDeparture=" + countryOfDeparture
				+ ", cityOfDeparture=" + cityOfDeparture + ", airportOfDeparture=" + airportOfDeparture
				+ ", terminalOfDeparture=" + terminalOfDeparture + ", gateOfDeparture=" + gateOfDeparture
				+ ", dateOfDeparture=" + getStringDateOfDeparture() + ", timeOfDeparture=" + timeOfDeparture
				+ ", countryOfArrival=" + countryOfArrival + ", cityOfArrival=" + cityOfArrival + ", airportOfArrival="
				+ airportOfArrival + ", terminalOfArrival=" + terminalOfArrival + ", gateOfArrival=" + gateOfArrival
				+ ", dateOfArrival=" + getStringDateOfArrival() + ", timeOfArrival=" + timeOfArrival + "]";
	}

	
	
}
