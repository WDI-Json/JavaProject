package routeplannerpoc.windesheimdemo.model;

import java.util.ArrayList;

public class Order {
    // public ArrayList<Article> itemsBought;
    public ArrayList<String> itemsBought;
    private Customer customer;
    private Boolean readyforshipment;
    private Boolean isreturnorder;
    private static String orderID = "0";

    public Order(Customer customer, ArrayList<String> itemsBought,  boolean readyforshipment, boolean isreturnorder) {
        this.itemsBought = itemsBought;
        this.customer = customer;
        this.readyforshipment = false;
        this.isreturnorder = false;
        this.orderID = getNextUniqueID();
    }

    public static String getNextUniqueID() {
        int id = Integer.parseInt(orderID);     
        ++id;                                    
        orderID = Integer.toString(id);         
        return orderID;                        
    }

    public Customer getCustomer() {
        return customer;
    }

    public Boolean getIsreturnorder() {
        return isreturnorder;
    }

    public ArrayList<String> getItemsBought() {
        return itemsBought;
    }

    public static String getOrderID() {
        return orderID;
    }

    public Boolean getReadyforshipment() {
        return readyforshipment;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setIsreturnorder(Boolean isreturnorder) {
        this.isreturnorder = isreturnorder;
    }

    public static void setOrderID(String orderID) {
        Order.orderID = orderID;
    }

    public void setItemsBought(ArrayList<String> itemsBought) {
        this.itemsBought = itemsBought;
    }
    
    public void setReadyforshipment(Boolean readyforshipment) {
        this.readyforshipment = readyforshipment;
    }
}
