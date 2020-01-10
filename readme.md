
## Exercise

Create a single page application in Java (Frameworks allowed) that uses the provided
database (SQLite 3) to list and categorize country phone numbers.
Phone numbers should be categorized by country, state (valid or not valid), country
code and number.
The page should render a list of all phone numbers available in the DB. It should be
possible to filter by country and state. Pagination is an extra.

Topics to take into account:

- Try to show your OOP skills
- Code standards/clean code
- Do not use external libs to validate the numbers.
- Unit Tests

Regular expressions to validate the numbers:

Cameroon | Country code: +237 | Regex = \(237\)\ ?[2368]\d{7,8}$
Ethiopia | Country code: +251 | Regex = \(251\)\ ?[1-59]\d{8}$
Morocco | Country code: +212 | Regex = \(212\)\ ?[5-9]\d{8}$
Mozambique | Country code: +258 | Regex = \(258\)\ ?[28]\d{7,8}$
Uganda | Country code: +256 | Regex = \(256\)\ ?\d{9}$

## Resolution

### A Single Page Application was developed in Java using Spring Boot Framework.

To run the application Maven must be installed, and you can use the following command:

mvn spring-boot:run

The Application is available at http://localhost:8080

### Features developed

* Connection to SQLite database

* List all Customers ( with id, name, phone attributes)
Get http://localhost:8080/getcustomers

* List all Customers by Country Code Phone
http://localhost:8080/getcustomerByCountryPhones?code=258

* List all Customers by State of Phone (Valid or Invalid)
http://localhost:8080/getcustomersByStatePhones?valid=1

#### All these features were addressed without creating a new table or columns.

### Unit tests were done using TestCase framework.

### Generation of Jar File to Deploy

- Dependencies added to pom.xml
- Run on command line: mvn clean package
The file is saved on "target" folder


### A Dockerfile was created. However it was not running, some fixes have to be done.

### FrontEnd needs to be developed in a future opportunity.




