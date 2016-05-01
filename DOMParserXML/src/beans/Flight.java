/**
 * 
 */
package beans;

/**
 * @author Andrei Yahorau
 *
 */
public class Flight {

	private String numberFlight;
	private String numberAircraft;
	private String typeAircraft;
	private String modelAircraft;
	private InfoFlightData departure;
	private InfoFlightData arrival;

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
	 * @return the departure
	 */
	public InfoFlightData getDeparture() {
		return departure;
	}

	/**
	 * @param departure
	 *            the departure to set
	 */
	public void setDeparture(InfoFlightData departure) {
		this.departure = departure;
	}

	/**
	 * @return the arrival
	 */
	public InfoFlightData getArrival() {
		return arrival;
	}

	/**
	 * @param arrival
	 *            the arrival to set
	 */
	public void setArrival(InfoFlightData arrival) {
		this.arrival = arrival;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [numberFlight=" + numberFlight + ", numberAircraft=" + numberAircraft + ", typeAircraft="
				+ typeAircraft + ", modelAircraft=" + modelAircraft + ", departure=" + departure + ", arrival="
				+ arrival + "]";
	}

}
