/*
 * Customer Controller:
 * The objective is to give the routes of the Application.
 * For each route specific methods of the services are called.
 * 
 */

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
		
	// It is required a Customer Service
	@Autowired
	private CustomerService customerService;
	
	
	//Route for GET all customers	
	@GetMapping("/getcustomers")
 	
	//It will show the customer model which contains the information about id, name, phone	
 	@ResponseBody
    public List<Customer> getAll() {
 		return customerService.selectAll(); 		
    }
	
	// Route for GET all customer's phones by code country 
	@GetMapping("/getcustomerByCountryPhones")
	
	//It will show a List of customers which phones matches with the code country written in query
	@ResponseBody
	public List<Customer> getPhonesByCountry(@RequestParam("code") int countryCode) {
		return customerService.selectCustomerPhoneCountry(countryCode);
	}
	
	//Route for GET all customer's phones by valid or invalid phone number
	@GetMapping("/getcustomersByStatePhones")
 	
	//It will show a List of customers which phones matches with the regular Expression defined by Client, 
	//valid or invalid flag is written in query
	@ResponseBody
	public List<Customer> getPhonesByState(@RequestParam("valid") int state) {
		return customerService.selectCustomerPhoneState(state);
	}
}
