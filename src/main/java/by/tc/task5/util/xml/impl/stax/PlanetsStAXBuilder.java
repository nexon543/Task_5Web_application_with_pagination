package by.tc.task5.util.xml.impl.stax;

import by.tc.task5.entity.Planet;
import by.tc.task5.util.xml.PlanetEnum;
import by.tc.task5.util.xml.PlanetsBuilder;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanetsStAXBuilder implements PlanetsBuilder {

    private List<Planet> planets=new ArrayList<>();
    private XMLInputFactory inputFactory;

    public PlanetsStAXBuilder(){
        inputFactory=XMLInputFactory.newInstance();
    }
    @Override
    public void buildPlanets(String fileName) throws IOException, SAXException {
        FileInputStream inputStream=null;
        XMLStreamReader reader=null;
        String name;

        try {
            inputStream=new FileInputStream(new File(fileName));
            reader=inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext()){
                int type=reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    name=reader.getLocalName();
                    if (PlanetEnum.valueOf(name.toUpperCase())==PlanetEnum.PLANET){
                        Planet planet=buildPlanet(reader);
                        planets.add(planet);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Planet> getPlanets() {
        return planets;
    }

    public Planet buildPlanet(XMLStreamReader reader) throws XMLStreamException {
        Planet planet=new Planet();
        String fieldName, fieldValue;
        while (reader.hasNext()){
            int type=reader.next();
            switch(type){
                case XMLStreamConstants.START_ELEMENT:
                    fieldName=reader.getLocalName();
                    fieldValue=getXMLText(reader);
                    switch(PlanetEnum.valueOf(fieldName.toUpperCase())){
                        case DIAMETER:
                            planet.setDiameter(Integer.parseInt(fieldValue));
                            break;
                        case NAME:
                            planet.setName(fieldValue);
                            break;
                        case YEAROFDISCOVERING:
                            planet.setYearOfDiscovering(Integer.parseInt(fieldValue));
                            break;
                        case ORBITALPERIOD:
                            planet.setOrbitalPeriod(Integer.parseInt(fieldValue));
                            break;
                    }
                    break;
                    case XMLStreamConstants.END_ELEMENT:
                        fieldName=reader.getLocalName();
                        if (PlanetEnum.valueOf(fieldName.toUpperCase()) == PlanetEnum.PLANET){
                            return planet;
                        }
            }
        }
        throw new XMLStreamException("Unknown element in xml file");
    }
    public String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text=null;
        if (reader.hasNext()){
            reader.next();
            text=reader.getText();
        }
        return text;
    }
}
