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
    SpringApplication.run(WindesheimDemoApplication.class, args);
  }
}
