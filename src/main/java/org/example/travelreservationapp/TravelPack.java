package org.example.travelreservationapp;

public class TravelPack {
    private String name;
    private String description;
    private double price;
    private String[] locations;
    private String[] activities;
    private boolean isSelected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public String[] getActivities() {
        return activities;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    public TravelPack() {
    }
    public void setVariable(String key,String value){
        switch (key){
            case "name":
                this.name = value;
                break;
            case "price":
                this.price = Double.parseDouble(value);
                break;
            case "locations":
                this.locations = value.split(",");
                break;
            case "activities":
                this.activities = value.split(",");
                break;
            case "description":
                this.description = value;
                break;
        }
    }
    public String printLocations(){
        StringBuilder locations = new StringBuilder();
        for (String location : this.locations) {
            locations.append(location).append(", ");
        }
        return locations.toString();
    }
    public String printActivities(){
        StringBuilder activities = new StringBuilder();
        for (String activity : this.activities) {
            activities.append(activity).append(", ");
        }
        return activities.toString();
    }
}
