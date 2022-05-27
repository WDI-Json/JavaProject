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


@Controller
public class CustomerController {

  @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
  public String customerForm(Model model) {
    model.addAttribute("customer", new Customer(null, null, null, null, null, null, null));
    return "customer";
  }

  @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json") /*
                                                                                                    * produces !=
                                                                                                    * accepts
                                                                                                    */
  @ResponseBody()
  public ResponseEntity<String> customerSubmit(@ModelAttribute Customer customer, Model model) {
    model.addAttribute("customer", customer);
    return new ResponseEntity<String>(customer.toString(), HttpStatus.OK);
  }
}
