/**
 * 
 */
package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import beans.Flight;
import beans.InfoFlightData;

/**
 * @author Andrei Yahorau
 *
 */
public class FlightsDOMBuilder {

	private List<Flight> shedule;
	private DocumentBuilder documentBuilder;

	/**
	 * @param shedule
	 * @param documentBuilder
	 */
	public FlightsDOMBuilder() {
		this.shedule = new ArrayList<Flight>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			documentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the shedule
	 */
	public List<Flight> getShedule() {
		return shedule;
	}

	/**
	 * 
	 * @param fileName
	 */
	public void biuldListFlights(String fileName) {
		Document doc = null;
		try {
			// parsing XML and create tree structure
			doc = documentBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			// get list child of element <flight>
			NodeList flightsList = root.getElementsByTagName("flight");
			for (int i = 0; i < flightsList.getLength(); i++) {
				Element flightElement = (Element) flightsList.item(i);
				Flight flight = buildFlight(flightElement);
				shedule.add(flight);
			}
		} catch (IOException e) {
			System.err.println("File error or I/O error: " + e);
		} catch (SAXException e) {
			System.err.println("Parsing failure: " + e);
		}

	}

	/**
	 * Create the object the Flight
	 * 
	 * @param flightElement
	 * @return the flight
	 */
	private Flight buildFlight(Element flightElement) {
		Flight flight = new Flight();
		// create flight
		flight.setNumberFlight(flightElement.getAttribute("number"));
		Element aircraftElement = (Element) flightElement.getElementsByTagName("aircraft").item(0);
		flight.setNumberAircraft(aircraftElement.getAttribute("number"));
		flight.setTypeAircraft(getElementTextContent(aircraftElement, "type"));
		flight.setModelAircraft(getElementTextContent(aircraftElement, "model"));
		Element departureElement = (Element) flightElement.getElementsByTagName("departure").item(0);
		InfoFlightData departure = buildInfoFlight(departureElement);
		flight.setDeparture(departure);
		Element arrivalElement = (Element) flightElement.getElementsByTagName("arrival").item(0);
		InfoFlightData arrival = buildInfoFlight(arrivalElement);
		flight.setArrival(arrival);
		return flight;
	}

	/**
	 * 
	 * @param element
	 * @return the info about flight
	 */
	private InfoFlightData buildInfoFlight(Element element) {
		InfoFlightData infoFlightData = new InfoFlightData();
		// Create the info-object arrival or departure
		infoFlightData.setCountry(getElementTextContent(element, "country"));
		infoFlightData.setCity(getElementTextContent(element, "city"));
		infoFlightData.setAirport(getElementTextContent(element, "airport"));
		infoFlightData.setTerminal(getElementTextContent(element, "terminal"));
		infoFlightData.setGate(getElementTextContent(element, "gate"));
		Element dateElement = (Element) element.getElementsByTagName("date").item(0);
		String date = getElementTextContent(dateElement, "date");
		String time = getElementTextContent(dateElement, "time");
		infoFlightData.setDate(date);
		infoFlightData.setTime(time);
		return infoFlightData;
	}

	/**
	 * get text content from tag
	 * 
	 * @param element
	 * @param elementName
	 * @return the text element
	 */
	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

	/**
	 * 
	 * @param fileName
	 * @param shedule
	 * @throws TransformerException
	 */
	public void exportSheduleToXML(String fileName, List<Flight> shedule) throws TransformerException {

		Document document = this.documentBuilder.newDocument();
		Element rootElement = document.createElement("shedule");
		document.appendChild(rootElement);
		rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xmlns", "http://www.epamlab");
		rootElement.setAttribute("xsi:schemaLocation", "http://www.epamlab Shedule.xsd");

		for (Flight flight : shedule) {

			//create element departure
			InfoFlightData departure = flight.getDeparture();
			Element departureElement = createInfoFlightData("departure", document, departure);
			
			//create element arrival
			InfoFlightData arrival = flight.getArrival();
			Element arrivalElement = createInfoFlightData("arrival", document, arrival);
			
			//create element aircraft
			Element typeElement = document.createElement("type");
			Element modelElement = document.createElement("model");
			typeElement.appendChild(document.createTextNode(flight.getTypeAircraft()));
			modelElement.appendChild(document.createTextNode(flight.getModelAircraft()));
			Element aircraftElement = document.createElement("aircraft");
			aircraftElement.setAttribute("number", flight.getNumberAircraft());
			aircraftElement.appendChild(typeElement);
			aircraftElement.appendChild(modelElement);

			//create element Flight and its attribute - number
			Element flightElement = document.createElement("flight");
			flightElement.setAttribute("number", flight.getNumberFlight());

			flightElement.appendChild(aircraftElement);
			flightElement.appendChild(departureElement);
			flightElement.appendChild(arrivalElement);
			rootElement.appendChild(flightElement);

		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(fileName));
		transformer.transform(source, result);

	}

	/**
	 * this method create the object InfoFlightData which it contains information about departure or arrival 
	 * 
	 * @param nameInfo
	 * @param document
	 * @param infoFlightData
	 * @return the element of xml then give information about the flight
	 */
	private Element createInfoFlightData(String nameInfo, Document document, InfoFlightData infoFlightData) {
		Element dateElement = document.createElement("date");
		dateElement.appendChild(document.createTextNode(infoFlightData.getStringDate()));
		Element timeElement = document.createElement("time");
		timeElement.appendChild(document.createTextNode(infoFlightData.getStringTime()));
		Element dateInfoElement = document.createElement("date");
		dateInfoElement.appendChild(dateElement);
		dateInfoElement.appendChild(timeElement);
		Element countryElement = document.createElement("country");
		Element cityElement = document.createElement("city");
		Element airportElement = document.createElement("airport");
		Element terminalElement = document.createElement("terminal");
		Element gateElement = document.createElement("gate");
		countryElement.appendChild(document.createTextNode(infoFlightData.getCountry()));
		cityElement.appendChild(document.createTextNode(infoFlightData.getCity()));
		airportElement.appendChild(document.createTextNode(infoFlightData.getAirport()));
		terminalElement.appendChild(document.createTextNode(infoFlightData.getTerminal()));
		gateElement.appendChild(document.createTextNode(infoFlightData.getGate()));
		Element elementInfo = document.createElement(nameInfo);
		elementInfo.appendChild(countryElement);
		elementInfo.appendChild(cityElement);
		elementInfo.appendChild(airportElement);
		elementInfo.appendChild(dateElement);
		elementInfo.appendChild(terminalElement);
		elementInfo.appendChild(gateElement);
		return elementInfo;
	}
}
