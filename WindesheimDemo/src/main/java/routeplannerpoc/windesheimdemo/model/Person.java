package routeplannerpoc.windesheimdemo.model;

public abstract class Person {
    String firstname;
    String lastname;
    Boolean isemployee;
    Address address;

    public Person(String firstname, String lastname, String country, String streetname, Integer housenumber, String cityname, String postalcode){
        this.address = new Address(country, streetname, housenumber, cityname, postalcode);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }
    public String getFirstname() {
        return firstname;
    }
    public Boolean getIsemployee() {
        return isemployee;
    }
    public String getLastname() {
        return lastname;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setIsemployee(Boolean isemployee) {
        this.isemployee = isemployee;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
