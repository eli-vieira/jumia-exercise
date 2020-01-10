/*
 * Customer Service:
 * The objective is to hold all the logic of the Application 
 * 
 * 
 */
package jumia.exercise.customers.service;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jumia.exercise.customers.model.Customer;

@Service
public class CustomerService {
	
	// Connect to database SQLite
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:database/sample.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }	
		
	//Selects columns in database and for each Result a new CustomerModel is Created.
	//It returns a list of Customers.
	public List<Customer> selectAll() {
	        String sql = "SELECT id, name, phone FROM customer";
	                               
	        List<Customer> customerList = new ArrayList<Customer>(); 
	        
	        try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){	            	                    
	        	
	        	// loop through the result set
	        	while(rs.next()) {
	        		//sizeRS = sizeRS+1;
	        		int id = rs.getInt("id");
	        		String name = rs.getString("name");
	        		String phone = rs.getString("phone");
	        		Customer customer = new Customer(id, name, phone);
	        		customerList.add(customer);	            	
	            	
	        	}	        	
	        	return customerList;
	                  
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());    
	        	return null;
	        }       
	        
	        
	    }

	//A customer.phone is given as argument, and after splitting the string the result is the country code 	
	public int getCodeCountry(String phone) {
		
		if (phone != "") {
			String[] arrOfStr = phone.split("\\) ");
			String codeStrTemp = arrOfStr[0];		
			
			String[] arrOfStr2 = codeStrTemp.split("\\(");
			String codeStr = arrOfStr2[1];			
			
			int code = Integer.parseInt(codeStr); 
			return code;
		}
		else {
			return -1;
		}
	}
	
	/*NOT USED
	//A customer.phone is given as argument, and after splitting the String the result is the Phone number without the country code
	public String getPhoneNumber(String phone) {
		String[] arrOfStr = phone.split("\\) ");		
		String phoneStr = arrOfStr[1];

		return phoneStr;
	}
	*/
	
	//An int state = 0 or state = 1 is given as argument
	//valid if state = 1
	//invalid if state = 0
	//It returns a list of customers with valid or invalid state	
	public List<Customer> selectCustomerPhoneState(int state){
		List<Customer> allCustomers = selectAll();
		List<Customer> ValidList = new ArrayList<Customer>(); 
		
		for (int i=0; i<allCustomers.size(); i++) {
			Customer customer = allCustomers.get(i);
			
			boolean isValid = checkStateCustomerPhone(state, customer);
			
			if (isValid) {
				ValidList.add(customer);
			}
			
		}
		
		if (ValidList.isEmpty()) {
			return null;
		}
		else {
			return ValidList;
		}	
	}
	
	//It checks Customer Phone state returning true or false
	//check valid if state = 1
	//check invalid if state = 0
	public boolean checkStateCustomerPhone(int state, Customer customer){
				
		String regExp = "";		
					
		String phone = customer.getPhone();		
		
		int codeCountry = this.getCodeCountry(phone);
		
		if (codeCountry == 237) {
			regExp = "\\(237\\)\\ ?[2368]\\d{7,8}$";
		}
		else if (codeCountry == 251){
			regExp = "\\(251\\)\\ ?[1-59]\\d{8}$";
		}
		else if (codeCountry == 212){				
			regExp = "\\(212\\)\\ ?[5-9]\\d{8}$";
		}
		else if(codeCountry == 258){
			regExp = "\\(258\\)\\ ?[28]\\d{7,8}$";
		}
		else if(codeCountry == 256){
			regExp = "\\(256\\)\\ ?\\d{9}$";
		}
		
		if (state == 1 ) { // isvalid
			if (phone.matches(regExp)) {
				return true;				
			}
			else {
				return false;
			}
		}
		else {
			if (!phone.matches(regExp)) {
				return true;
			}
			else {
				return false;
			}
		}							
	}
	
	//An int codeCountry is given as argument
	//For all customers in database it checks which customers
	//have phone number with code country = argument
	//It returns a list of customers
	public List<Customer> selectCustomerPhoneCountry(int codeCountry){
		List<Customer> allCustomers = selectAll();
		List<Customer> CountryList = new ArrayList<Customer>(); 
		
		for (int i=0; i<allCustomers.size(); i++) {
			Customer customer = allCustomers.get(i);
			
			boolean isOfCountry = checkCountryCustomerPhone(codeCountry, customer);					
			
			if (isOfCountry) {
				CountryList.add(customer);
			}
			
		}
		
		if (CountryList.isEmpty()) {
			return null;
		}
		else {
			return CountryList;
		}	
	}
	
	//It checks Customer Phone code country returning true or false
	public boolean checkCountryCustomerPhone(int codeCountry, Customer customer) {								
			
		String phone = customer.getPhone();		
		
		//Save phones on list
		int code = this.getCodeCountry(phone);
		
		if (code != -1) {
			
			//Save List of phones on country constructors
			
			if (code == codeCountry) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
													
}
