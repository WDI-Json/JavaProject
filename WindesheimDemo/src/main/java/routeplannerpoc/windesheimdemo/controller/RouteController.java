package routeplannerpoc.windesheimdemo.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody()
@RestController
@Controller
public class RouteController {

  @RequestMapping(value = "/response", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<String> postBody(@RequestBody String input) {

      return new ResponseEntity<String>(input,HttpStatus.OK);
  }

  @RequestMapping(value = "/availableroutes", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<String> response(@RequestBody String order) {

      return new ResponseEntity<String>(order, HttpStatus.OK);
  }
}

