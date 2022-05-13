package routeplannerpoc.windesheimdemo.model;


public class Customer extends Person{
    private static String customerID = "0";

    
    public Customer(String firstname, String lastname, String country, String streetname, Integer housenumber,
            String cityname, String postalcode) {
        super(firstname, lastname, country, streetname, housenumber, cityname, postalcode);
        customerID = getNextUniqueID();
    }

    public static String getCustomerID() {
        return customerID;
    }
    @Override
    public void setAddress(Address address) {
        // TODO Auto-generated method stub
        super.setAddress(address);
    }
    @Override
    public void setFirstname(String firstname) {
        // TODO Auto-generated method stub
        super.setFirstname(firstname);
    }
    @Override
    public void setLastname(String lastname) {
        // TODO Auto-generated method stub
        super.setLastname(lastname);
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
        "\"FirstName\":" + "\""+ this.getFirstname() + "\","+
        "\"LastName\":" + "\""+ this.getLastname() + "\","+
        "\"Address\":" + this.getAddress() + "}";
    }
    
}
