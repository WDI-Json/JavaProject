package routeplannerpoc.windesheimdemo.model;

public class Address {
    private String country;
    private String streetName;
    private Integer houseNumber;
    private String cityName;
    private String postalCode; 
    // public GeoLocation geolocation;

    public Address(String country, String streetName, Integer houseNumber, String cityName, String postalCode) {
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString() {
        return "{" + "\"streetname\":" + "\""+this.streetName + "\""+
        "," + "\"housenumber\":" +this.houseNumber +
        "," + "\"postalcode\":" + "\""+this.postalCode + "\""+
        "," + "\"cityname\":" + "\""+this.cityName + "\""+
        "," + "\"country\":" + "\""+this.country +"\""+ "}";
    }
}
