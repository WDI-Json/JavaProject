package routeplannerpoc.windesheimdemo.model;

public abstract class Person {
    String firstName;
    String lastName;
    Boolean isEmployee;
    Address address;

    public Person(String firstName, String lastName, String country, String streetName, Integer houseNumber, String cityName, String postalCode){
        this.address = new Address(country, streetName, houseNumber, cityName, postalCode);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAddress() {
        return address.toString();
    }

    public Address getAddressObject() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public String getLastName() {
        return lastName;
    }
}
