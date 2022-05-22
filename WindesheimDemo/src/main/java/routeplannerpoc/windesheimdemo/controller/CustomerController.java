package routeplannerpoc.windesheimdemo.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import routeplannerpoc.windesheimdemo.model.Customer;

// import routeplannerpoc.windesheimdemo.geocoder.Geocoder;


@Controller
public class CustomerController {

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    public String customerForm(Model model) {
      model.addAttribute("customer", new Customer(null, null, null, null, null, null, null));
      return "customer"; //Dit moet ik nog ff fixen. snap niet zo goed wat hier gebeurd.
    }

    // curl -vvv -H 'Content-Type: application/x-www-form-urlencoded'  -XPOST http://127.0.0.1:8080/customer -d 'country=blaat&cityname=Opgezwollen&postcalcode=1122&housenumber=42'
    // this works
    //
    // curl -vvv -H 'Content-Type: application/json'  -XPOST http://127.0.0.1:8080/customer -d '{ "country": "blaat" }'
    // this doesnt (as country is not being set)
    //
    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json") /* produces != accepts */
    @ResponseBody()
    public ResponseEntity<String> customerSubmit(@ModelAttribute Customer customer, Model model) {
      model.addAttribute("customer", customer);
      return new ResponseEntity<String>(customer.toString(), HttpStatus.OK);
    }
}
    // @GetMapping("/customer")
    // public String sendForm(Customer customer) {

    //     return "customer";
    // }

    // @PostMapping("/customer")
    // public String processForm(Customer customer) {

    //     return "showMessage";
    // }
    // }



    // public String convertToGeo(Address address) {
    //     String geocode;
    //     ObjectMapper mapper = new ObjectMapper();
    //     Geocoder geocoder = new Geocoder();

    //     String response = geocoder.GeocodeSync(address.toString()); //"11 Wall St, New York, NY 10005");
    //     JsonNode responseJsonNode = mapper.readTree(response);

    //     JsonNode items = responseJsonNode.get("items");

    //     for (JsonNode item : items) {
    //         JsonNode addressInput = item.get("address");
    //         String label = addressInput.get("label").asText();
    //         JsonNode position = item.get("position");

    //         String lat = position.get("lat").asText();
    //         String lng = position.get("lng").asText();
    //         String returnvalue = "{title: "+ label + ",\n" + "location: { lat:" + lat + ", lng:" + lng + "}";
    //         System.out.println(returnvalue);
    //         geocode = returnvalue;
    //     }
    //     return geocode;
    // }
// }
