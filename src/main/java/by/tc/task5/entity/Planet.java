package by.tc.task5.entity;

public class Planet {
    private String name;
    private int diameter;
    private int yearOfDiscovering;
    private int orbitalPeriod;


    public Planet() {
        super();
    }

    @Override
    public String toString() {
        return "Planet [name=" + name + ", diameter=" + diameter + ", yearOfDiscovering=" + yearOfDiscovering
                + ", orbitalPeriod=" + orbitalPeriod + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + diameter;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + orbitalPeriod;
        result = prime * result + yearOfDiscovering;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        if (diameter != other.diameter)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (orbitalPeriod != other.orbitalPeriod)
            return false;
        if (yearOfDiscovering != other.yearOfDiscovering)
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getYearOfDiscovering() {
        return yearOfDiscovering;
    }

    public void setYearOfDiscovering(int yearOfDiscovering) {
        this.yearOfDiscovering = yearOfDiscovering;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(int orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

}
