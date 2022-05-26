package routeplannerpoc.windesheimdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import routeplannerpoc.windesheimdemo.Dijkstra.Dijkstra;
import routeplannerpoc.windesheimdemo.Dijkstra.Node;

@ResponseBody()
@RestController
@Controller
public class RouteController {

  @RequestMapping(value = "/response", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<String> postBody(@RequestBody String input) {
    String Route = createRoute(input);
    return new ResponseEntity<String>(Route, HttpStatus.OK);
  }

  @RequestMapping(value = "/availableroutes", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<String> response(@RequestBody String order) {

    return new ResponseEntity<String>(order, HttpStatus.OK);
  }

  private String createRoute(String inputRoute) {
    JSONArray jsonObj = new JSONArray(inputRoute);
    JSONArray outputRoute = new JSONArray();

    List<Node> nodes = new ArrayList<>();
    for (int n = 0; n < jsonObj.length(); n++) {
      System.out.println("*******LOCATION: " + String.valueOf(n) + "+*********************\n");
      JSONObject object = jsonObj.getJSONObject(n);
      System.out.println("**********GEOLOCS*************");
      JSONObject geolocation = object.getJSONObject("location");
      System.out.print(geolocation);
      nodes.add(new Node(object.toString(), geolocation.getDouble("lat"), geolocation.getDouble("lng")));
    }
    List<Node> optimalPath = Dijkstra.DijkstraRouteOrder(nodes);
    for (Node loc : optimalPath) {
      JSONObject row = new JSONObject(loc.toString());
      outputRoute.put(row);
    }
    return outputRoute.toString();
  }
}
