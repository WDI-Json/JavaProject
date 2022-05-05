package routeplannerpoc.windesheimdemo.model;

public class Address {
    private static String addressID = "0";

    private String country;
    private String streetName;
    private Integer houseNumber;
    private String cityName;
    private String postalCode; 

    public Address(String country, String streetName, Integer houseNumber, String cityName, String postalCode) {
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityName = postalCode;
        addressID = getNextUniqueID();
    }
    
    public static String getNextUniqueID() {
        int id = Integer.parseInt(addressID);     
        ++id;                                    
        addressID = Integer.toString(id);         
        return addressID;                        
    }
    @Override
    public String toString() {
        return this.streetName + " " + this.houseNumber + " " + this.cityName + " " + this.country;
    }
}
