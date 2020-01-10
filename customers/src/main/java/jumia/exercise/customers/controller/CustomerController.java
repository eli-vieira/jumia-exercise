package jumia.exercise.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jumia.exercise.customers.service.CustomerService;
import jumia.exercise.customers.model.*;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getcustomers")
 	
 	@ResponseBody
    public List<Customer> getAll() {
 		return customerService.selectAll(); 		
    }
	
	@GetMapping("/getcustomerByCountryPhones")
	 	
	@ResponseBody
	public List<Customer> getPhonesByCountry(@RequestParam("code") int countryCode) {
		return customerService.selectCustomerPhoneCountry(countryCode);
	}
	
	@GetMapping("/getcustomersByStatePhones")
 	
	@ResponseBody
	public List<Customer> getPhonesByState(@RequestParam("valid") int state) {
		return customerService.selectCustomerPhoneState(state);
	}
}
