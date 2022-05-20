package routeplannerpoc.windesheimdemo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import routeplannerpoc.windesheimdemo.model.Customer;
import routeplannerpoc.windesheimdemo.model.Order;

@SpringBootApplication
public class WindesheimDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindesheimDemoApplication.class, args);

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
    Order order = new Order(bob, art, false, false);
    System.out.println(order.toString());
	}
}

