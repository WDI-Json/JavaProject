package routeplannerpoc.windesheimdemo.model;

public class Address {
    private String country;
    private String streetname;
    private Integer housenumber;
    private String cityname;
    private String postalcode; 
    // public GeoLocation geolocation;

    public Address(String country, String streetname, Integer housenumber, String cityname, String postalcode) {
        this.country = country;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.cityname = cityname;
        this.postalcode = postalcode;
    }
    
    @Override
    public String toString() {
        return "{" + "\"streetname\":" + "\""+this.streetname + "\""+
        "," + "\"housenumber\":" +this.housenumber +
        "," + "\"postalcode\":" + "\""+this.postalcode + "\""+
        "," + "\"cityname\":" + "\""+this.cityname + "\""+
        "," + "\"country\":" + "\""+this.country +"\""+ "}";
    }

    public String getCityname() {
        return cityname;
    }
    public String getCountry() {
        return country;
    }
    public Integer getHousenumber() {
        return housenumber;
    }
    public String getPostalcode() {
        return postalcode;
    }
    public String getStreetname() {
        return streetname;
    }
}
