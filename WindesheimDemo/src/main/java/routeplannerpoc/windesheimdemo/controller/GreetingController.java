package routeplannerpoc.windesheimdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
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
@ResponseBody
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

	String jsonString = ("{  \n\tID: " + greeting.getId() + ", \n" + 
	"\tCityname:" + greeting.getCityname() + ", \n" +
	"\tContent:" + greeting.getContent() + " \n }"); 
	
    return new ResponseEntity<String>(jsonString, 
	HttpStatus.OK);
  }
}