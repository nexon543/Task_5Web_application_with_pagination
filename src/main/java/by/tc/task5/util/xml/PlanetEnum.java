package by.tc.task5.util.xml;

public enum PlanetEnum {
    PLANETS("planets"),
    DIAMETER("diameter"),
    NAME("name"),
    ORBITALPERIOD("orbitalPeriod"),
    YEAROFDISCOVERING("yearOfDiscovering");
    private String value;
    private PlanetEnum(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
