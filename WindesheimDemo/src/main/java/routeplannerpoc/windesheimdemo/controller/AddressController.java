// package routeplannerpoc.windesheimdemo.controller;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import routeplannerpoc.windesheimdemo.geocoder.Geocoder;
// import routeplannerpoc.windesheimdemo.model.Address;

// @Controller
// public class AddressController {
    
//     public String convertToGeo(Address address) {
//         String geocode;
//         ObjectMapper mapper = new ObjectMapper();
//         Geocoder geocoder = new Geocoder();
        
//         String response = geocoder.GeocodeSync(address.toString()); //"11 Wall St, New York, NY 10005");
//         JsonNode responseJsonNode = mapper.readTree(response);

//         JsonNode items = responseJsonNode.get("items");

//         for (JsonNode item : items) {
//             JsonNode addressInput = item.get("address");
//             String label = addressInput.get("label").asText();
//             JsonNode position = item.get("position");

//             String lat = position.get("lat").asText();
//             String lng = position.get("lng").asText();
//             String returnvalue = "{title: "+ label + ",\n" + "location: { lat:" + lat + ", lng:" + lng + "}";
//             System.out.println(returnvalue);
//             geocode = returnvalue;
//         }
//         return geocode;
//     }
// }
