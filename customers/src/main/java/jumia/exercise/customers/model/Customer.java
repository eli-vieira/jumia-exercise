package jumia.exercise.customers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
public class Customer {
	
	private int id;
	private String name;
	
	private String phone;
    
	public Customer() {		
	}
	
	public Customer(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

    public String getPhone() {
		return phone;	
	}
    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }
    
}
	