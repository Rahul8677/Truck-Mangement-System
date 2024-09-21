package org.example;

public class Truck {
    private  int id;

    private String name;

    private String model;

    private int capicity;

    private String driverName;

    Truck()
    {

    }

    public Truck( String name, String model, int capicity, String driverName) {

        this.name = name;
        this.model = model;
        this.capicity = capicity;
        this.driverName = driverName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapicity() {
        return capicity;
    }

    public void setCapicity(int capicity) {
        this.capicity = capicity;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", capicity=" + capicity +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}