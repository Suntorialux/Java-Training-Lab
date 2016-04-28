/**
 * 
 */
package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

/**
 * @author Andrei Yahorau
 *
 */
public class FlightsDOMBuilder {

	private List<Flight> shedule;
	private DocumentBuilder documentBuilder;

	private final static DateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

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
	 * @throws ParseException
	 */
	public void biuldListFlights(String fileName) throws ParseException {
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
	 * 
	 * @param flightElement
	 * @return
	 * @throws ParseException
	 */
	private Flight buildFlight(Element flightElement) throws ParseException {
		Flight flight = new Flight();
		// create flight
		flight.setNumberFlight(flightElement.getAttribute("number"));
		Element aircraftElement = (Element) flightElement.getElementsByTagName("aircraft").item(0);
		flight.setNumberAircraft(aircraftElement.getAttribute("number"));
		flight.setTypeAircraft(getElementTextContent(aircraftElement, "type"));
		flight.setModelAircraft(getElementTextContent(aircraftElement, "model"));
		Element departureElement = (Element) flightElement.getElementsByTagName("departure").item(0);
		flight.setCountryOfDeparture(getElementTextContent(departureElement, "country"));
		flight.setCityOfDeparture(getElementTextContent(departureElement, "city"));
		flight.setAirportOfDeparture(getElementTextContent(departureElement, "airport"));
		flight.setTerminalOfDeparture(getElementTextContent(departureElement, "terminal"));
		flight.setGateOfDeparture(getElementTextContent(departureElement, "gate"));
		Element dateDepartureElement = (Element) departureElement.getElementsByTagName("date").item(0);
		Date dateDeparture = INPUT_DATE_FORMAT.parse(getElementTextContent(dateDepartureElement, "date"));
		flight.setDateOfDeparture(dateDeparture);
		flight.setTimeOfDeparture(getElementTextContent(dateDepartureElement, "time"));
		Element arrivalElement = (Element) flightElement.getElementsByTagName("arrival").item(0);
		flight.setCountryOfArrival(getElementTextContent(arrivalElement, "country"));
		flight.setCityOfArrival(getElementTextContent(arrivalElement, "city"));
		flight.setAirportOfArrival(getElementTextContent(arrivalElement, "airport"));
		flight.setTerminalOfArrival(getElementTextContent(arrivalElement, "terminal"));
		flight.setGateOfArrival(getElementTextContent(arrivalElement, "gate"));
		Element dateArrivalElement = (Element) arrivalElement.getElementsByTagName("date").item(0);
		Date dateArrival = INPUT_DATE_FORMAT.parse(getElementTextContent(dateArrivalElement, "date"));
		flight.setDateOfArrival(dateArrival);
		flight.setTimeOfArrival(getElementTextContent(dateArrivalElement, "time"));
		return flight;
	}


	
	/**
	 * get text content from tag
	 * 
	 * @param element
	 * @param elementName
	 * @return 
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
	public void exportSheduleToXML (String fileName, List<Flight> shedule) throws TransformerException {
		
		Document document = this.documentBuilder.newDocument();
		Element rootElement = document.createElement("shedule");
		document.appendChild(rootElement);
		rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xmlns","http://www.epamlab");
		rootElement.setAttribute("xsi:schemaLocation","http://www.epamlab Shedule.xsd");
		
		for(Flight flight : shedule) {
					
			Element dateElement = document.createElement("date");
			dateElement.appendChild(document.createTextNode(flight.getStringDateOfDeparture()));
			Element timeElement = document.createElement("time");
			timeElement.appendChild(document.createTextNode(flight.getTimeOfDeparture()));
			Element dateDepartureElement = document.createElement("date");
			dateDepartureElement.appendChild(dateElement);
			dateDepartureElement.appendChild(timeElement);
			Element countryDepartureElement = document.createElement("country");
			Element cityDepartureElement = document.createElement("city");
			Element airportDepartureElement = document.createElement("airport");
			Element terminalDepartureElement = document.createElement("terminal");
			Element gateDepartureElement = document.createElement("gate");
			countryDepartureElement.appendChild(document.createTextNode(flight.getCountryOfDeparture()));
			cityDepartureElement.appendChild(document.createTextNode(flight.getCityOfDeparture()));
			airportDepartureElement.appendChild(document.createTextNode(flight.getAirportOfDeparture()));
			terminalDepartureElement.appendChild(document.createTextNode(flight.getTerminalOfDeparture()));
			gateDepartureElement.appendChild(document.createTextNode(flight.getGateOfDeparture()));
			Element departure = document.createElement("departure");
			departure.appendChild(countryDepartureElement);
			departure.appendChild(cityDepartureElement);
			departure.appendChild(airportDepartureElement);
			departure.appendChild(terminalDepartureElement);
			departure.appendChild(gateDepartureElement);
			
			Element dateArrival = document.createElement("date");
			dateArrival.appendChild(document.createTextNode(flight.getStringDateOfArrival()));
			Element timeArrival = document.createElement("time");
			timeArrival.appendChild(document.createTextNode(flight.getTimeOfArrival()));
			Element dateArrivalElement = document.createElement("date");
			dateArrivalElement.appendChild(dateArrival);
			dateArrivalElement.appendChild(timeArrival);
			Element countryArrivalElement = document.createElement("country");
			Element cityArrivalElement = document.createElement("city");
			Element airportArrivalElement = document.createElement("airport");
			Element terminalArrivalElement = document.createElement("terminal");
			Element gateArrivalElement = document.createElement("gate");
			countryArrivalElement.appendChild(document.createTextNode(flight.getCountryOfArrival()));
			cityArrivalElement.appendChild(document.createTextNode(flight.getCityOfArrival()));
			airportArrivalElement.appendChild(document.createTextNode(flight.getAirportOfArrival()));
			terminalArrivalElement.appendChild(document.createTextNode(flight.getTerminalOfArrival()));
			gateArrivalElement.appendChild(document.createTextNode(flight.getGateOfArrival()));
			Element arrival = document.createElement("arrival");
			arrival.appendChild(countryArrivalElement);
			arrival.appendChild(cityArrivalElement);
			arrival.appendChild(airportArrivalElement);
			arrival.appendChild(terminalArrivalElement);
			arrival.appendChild(gateArrivalElement);
			
			Element typeElement = document.createElement("document");
			Element modelElement = document.createElement("model");
			typeElement.appendChild(document.createTextNode(flight.getTypeAircraft()));
			modelElement.appendChild(document.createTextNode(flight.getModelAircraft()));
			Element aircraftElement = document.createElement("aircraft");
			aircraftElement.setAttribute("number", flight.getNumberAircraft());
			aircraftElement.appendChild(typeElement);
			aircraftElement.appendChild(modelElement);
						
			Element flightElement = document.createElement("flight");
			flightElement.setAttribute("number", flight.getNumberFlight());
			
			flightElement.appendChild(aircraftElement);
			flightElement.appendChild(departure);
			flightElement.appendChild(arrival);
			rootElement.appendChild(flightElement);
			
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(fileName));
		transformer.transform(source, result);
		
	}

}
