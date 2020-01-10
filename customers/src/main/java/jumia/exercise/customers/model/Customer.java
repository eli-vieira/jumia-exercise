/*
 * Customer Model:
 * The objective is to build the Customer model according to the definition of 
 * the Customer Table that is in the provided database
 * 
 */

package jumia.exercise.customers.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	//Columns id, name and phone
	private int id;
	private String name;	
	private String phone;   
	
	//Empty Contructor of Customer
	public Customer() {

	}	
	
	//Contructor of Customer
	public Customer(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}	
	
	//get Id value
	public int getId() {
		return id;
	}
	
	//get Name value
	public String getName() {
		return name;
	}

	//get Phone value
    public String getPhone() {
		return phone;	
	}
    
    // Json output    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }
    
}
	