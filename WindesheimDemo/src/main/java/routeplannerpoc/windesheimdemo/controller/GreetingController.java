package routeplannerpoc.windesheimdemo.controller;

import java.util.List;
import java.util.Arrays;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Method;
import routeplannerpoc.windesheimdemo.model.Greeting;




@Controller
// @ResponseBody
@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @RequestMapping(value = "/greeting", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<String> greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
    model.addAttribute("greeting", greeting);
    return new ResponseEntity<String>("[{title: 'Hogeschool Windesheim,location': { lat: 52.49953, lng: 6.07845 }},{title: 'Engelse werk',location: { lat: 52.4970232, lng: 6.06394 }},{title: 'Scania',location: { lat: 52.5255141, lng: 6.0800041 }},{title: 'McDonalds Noord',location: { lat: 52.5224281, lng: 6.1145818 }},{title: 'Hogeschool Windesheim',location: { lat: 52.49953, lng: 6.07845 }}]" ,
	HttpStatus.OK);
  }
  
  @RequestMapping("/test")
  public List<Greeting> getAllGreetings() {
    return Arrays.asList(
    new Greeting(1, "hoi", "Zwolle"), 
    new Greeting(2, "hallo", "Zoetermeer"),
    new Greeting(3, "dag hoor", "Den Haag"),
    new Greeting(4, "tot ziens", "Hattem"));
  }
}