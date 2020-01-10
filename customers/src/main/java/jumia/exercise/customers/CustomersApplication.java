/* Developed by: Eliana Vieira
 * Contact: elianapvieira@gmail.com
 * 
 * This Application was developed for a JUMIA exercise
 * The structure is prepared to allow CRUD methods, however 
 * only GET methods were configured.
 * 
 * There project is divided into three subpackages: model, controller, service
 */
package jumia.exercise.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

}
