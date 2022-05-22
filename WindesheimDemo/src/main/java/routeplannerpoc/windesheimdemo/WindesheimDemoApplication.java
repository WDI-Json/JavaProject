package routeplannerpoc.windesheimdemo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import routeplannerpoc.windesheimdemo.model.Customer;
import routeplannerpoc.windesheimdemo.model.Order;


@SpringBootApplication
@ComponentScan(basePackages = { "routeplannerpoc.windesheimdemo" })
public class WindesheimDemoApplication {
	public static void main(String[] args) {
    System.out.println("HIJ DOET IETS");
		SpringApplication.run(WindesheimDemoApplication.class, args);


    Customer bob = new Customer(
      "Bob", "Bobson",
      "NL",
      "Regelandisstraat",
      17,
      "Zwolle",
      "8022BN");
    Order order = new Order(bob, false, false);


    System.out.println(order.toString());
	}
}

