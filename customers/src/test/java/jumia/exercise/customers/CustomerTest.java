package jumia.exercise.customers;

import  jumia.exercise.customers.model.Customer;
import  jumia.exercise.customers.service.*;

import java.util.List;
import java.util.ArrayList;
import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	private CustomerService customerService;
	
	// Unit Test for GET customer List
	public void testCustomerList() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(0, "Name1", "(212) 6007989255"));
		customerList.add(new Customer(1, "Name2", "(351) 6007989253"));
		customerList.add(new Customer(2, "Name3", "(351) 6007989253"));
		
		List<Customer>customerGetList = customerService.selectAll();
		
		assertTrue(customerGetList.contains(customerList.get(0)));
		assertTrue(customerGetList.contains(customerList.get(1)));
		assertTrue(customerGetList.contains(customerList.get(2)));
		
	}
	
	// Unit Test for checking if a Phone Number is valid
	public void testValidPhone() {
		
		Customer customer = new Customer(3, "Name4", "(351) 6007989253");
				
		assertFalse(customerService.checkStateCustomerPhone(1, customer));				
		
	}
	
	// Unit Test for cheking if a Phone belongs to a country
	public void testCountryPhone() {
		
		Customer customer = new Customer(4, "Name4", "(212) 6007989253");
				
		assertTrue(customerService.checkStateCustomerPhone(212, customer));				
		
	}
}
