package routeplannerpoc.windesheimdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routeplannerpoc.windesheimdemo.model.Address;
import routeplannerpoc.windesheimdemo.service.IAddressService;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private IAddressService AddressService;

    @RequestMapping(value = "/showaddresses", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> findCities(Model model) {

        var cities = (List<Address>) AddressService.findAll();

        model.addAttribute("cities", cities);

        // return "showCities";
        return new ResponseEntity<String>(String.valueOf(cities.size()), HttpStatus.OK);
    }
}
