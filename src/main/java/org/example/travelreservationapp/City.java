package org.example.travelreservationapp;

public class City {
    private TravelPackList travelPacks = new TravelPackList();
    private String name;
    private double price;
    private String  beginningDate;
    private String endDate;
    private String time;
    private String description;

    public TravelPackList getTravelPacks() {
        return travelPacks;
    }

    public void setTravelPacks(TravelPackList travelPacks) {
        this.travelPacks = travelPacks;
    }

    public City() {
    }

    public void setVariable(String key,String value){
        switch (key){
            case "name":
                this.name = value;
                break;
            case "price":
                this.price = Double.parseDouble(value);
                break;
            case "beginningDate":
                this.beginningDate = value;
                break;
            case "endDate":
                this.endDate = value;
                break;
            case "time":
                this.time = value;
                break;
            case "description":
                this.description = value;
                break;
        }
    }
    public void addTravelPack(TravelPack travelPack){
        travelPacks.add(travelPack);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(String beginningDate) {
        this.beginningDate = beginningDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}