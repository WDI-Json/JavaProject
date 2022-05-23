package routeplannerpoc.windesheimdemo.model;


public class Order {
  // public ArrayList<Article> itemsBought;
  private Customer customer;
  private Boolean readyforshipment;
  private Boolean isreturnorder;
  private static String orderID = "0";

  public Order(Customer customer, boolean readyforshipment, boolean isreturnorder) {
    this.customer = customer;
    this.readyforshipment = false;
    this.isreturnorder = false;
    orderID = getNextUniqueID();
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

  public void setReadyforshipment(Boolean readyforshipment) {
    this.readyforshipment = readyforshipment;
  }

  @Override
  public String toString() {
    return "{\"OrderID\":" + "\"" + orderID + "\"," +
        "\"ReadyForShipment\":" + "\"" + this.readyforshipment + "\"," +
        "\"isReturnOrder\":" + "\"" + this.isreturnorder + "\"," +
        "\"Customerinfo\": " +
        customer.toString() + "}";
  }
}
