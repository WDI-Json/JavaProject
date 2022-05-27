package RouteplannerPOC.WindesheimDemo.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import routeplannerpoc.windesheimdemo.model.Customer;
import routeplannerpoc.windesheimdemo.model.Order;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

  @Test
  void customerSubmit() {
    Customer bob = new Customer(
      "Bob", "Bobson",
      "NL",
      "Regelandisstraat",
      17,
      "Zwolle",
      "8022BN");
    ArrayList<String> art = new ArrayList<String>();
    art.add("Product1");
    art.add("product2");
    art.add("Product3");
    art.add("Product4");
    Order test = new Order(bob, false, false);
    assertEquals(true,testJSON(test.toString()));
  }

  public Boolean testJSON(String test) {
    try {
      new JSONObject(test);
    } catch (JSONException ex) {
      try {
        new JSONArray(test);
      } catch (JSONException ex1) {
        return false;
      }
    }
    return true;
  }
}
