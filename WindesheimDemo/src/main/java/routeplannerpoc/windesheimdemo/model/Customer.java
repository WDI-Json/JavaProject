package routeplannerpoc.windesheimdemo.model;

// import java.util.ArrayList;

public class Customer extends Person{
    private static String customerID = "0";
    // private ArrayList<Order> orders;

    public Customer(String firstName, String lastName, String country, String streetName, Integer houseNumber,
            String cityName, String postalCode) {
        super(firstName, lastName, country, streetName, houseNumber, cityName, postalCode);
        customerID = getNextUniqueID();
    }

    public static String getCustomerID() {
        return customerID;
    }

    public static String getNextUniqueID() {
        int id = Integer.parseInt(customerID);     
        ++id;                                    
        customerID = Integer.toString(id);         
        return customerID;                        
    }

    @Override
    public String toString() {
        return "{\"CustomerID\":" + "\""+customerID + "\","+
        "\"FirstName\":" + "\""+ this.getFirstName() + "\","+
        "\"LastName\":" + "\""+ this.getLastName() + "\","+
        "\"Address\":" + getAddress() + "}";
    }
    
}
