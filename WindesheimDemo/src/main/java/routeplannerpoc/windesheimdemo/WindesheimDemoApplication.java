package routeplannerpoc.windesheimdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import routeplannerpoc.windesheimdemo.Dijkstra.Node;
import routeplannerpoc.windesheimdemo.Dijkstra.Dijkstra;
import routeplannerpoc.windesheimdemo.model.Customer;
import routeplannerpoc.windesheimdemo.model.Order;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
    // Node nodeA = new Node("Windesheim[1]", 52.49953, 6.07845);
    // Node nodeB = new Node("EngelseWerk[2]", 52.4970232, 6.06394);
    // Node nodeC = new Node("Scania[3]", 52.5255141, 6.0800041);
    // Node nodeD = new Node("McDonaldsNoord[4]", 52.49953, 6.07845);
    // Node[] nodes = { nodeA, nodeB, nodeC, nodeD };
    // Dijkstra.DijkstraRouteOrder(nodes);
    // JSONArray jsonObj = new JSONArray("""
    //   [{"id":1,"value":"ORDER:1, CUSTOMER: 1, ISRETOUR: false, ADDRESS: campus 2 8017CA Zwolle","location":{"lat":52.49953,"lng":6.07845}},
    //   {"id":2,"value":"ORDER:2, CUSTOMER: 2, ISRETOUR: false, ADDRESS:    Barendrecht","location":{"lat":51.853,"lng":4.4539}},
    //   {"id":3,"value":"ORDER:3, CUSTOMER: 3, ISRETOUR: false, ADDRESS:    Zwolle","location":{"lat":52.5255141,"lng":6.0800041}},
    //   {"id":4,"value":"ORDER:4, CUSTOMER: 4, ISRETOUR: true, ADDRESS: campus 2 8017CA Zoetermeer","location":{"lat":52.0621451,"lng":4.4165747}}]
    //       """);
    //   List<Node> nodes= new ArrayList<>();
    //   for(int n = 0; n < jsonObj.length(); n++)
    //   {
    //     System.out.println("*******ROW"+ String.valueOf(n) +"+*********************");
    //       JSONObject object = jsonObj.getJSONObject(n);
    //       System.out.println("OBJECT:" + object);
    //       System.out.println("**********GEOLOCS*************");
    //       JSONObject geolocation = object.getJSONObject("location");
    //       System.out.print(geolocation);
    //       System.out.println("\nLAT: "+geolocation.getDouble("lat"));
    //       System.out.println("\nLNG: "+geolocation.getDouble("lng"));
    //       nodes.add(new Node(object.toString(), geolocation.getDouble("lat"), geolocation.getDouble("lng")));
    //   }
    //   Dijkstra.DijkstraRouteOrder(nodes);
  }
}
