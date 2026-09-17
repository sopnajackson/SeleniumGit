Selenium Web UI Automation Project

Project Overview
-	This project is a Web UI Test Automation project developed using Java, Selenium WebDriver, TestNG and Maven.
-	The project demonstrates the automation of key user workflows on a dummy e-commerce web application. It was created as a hands-on automation project to practise and demonstrate real-world software testing concepts including Page Object Model (POM), reusable automation methods, element locators, explicit waits, TestNG test execution, screenshots, reporting and Maven-based project management.
-	The project is maintained using Git and GitHub for version control.
________________________________________

Project Objectives
The main objectives of this project are to:
•	Automate important user journeys on an e-commerce application.
•	Develop maintainable Selenium automation code using Java.
•	Apply the Page Object Model (POM) design pattern.
•	Create reusable methods for common browser interactions.
•	Use reliable Selenium locators such as ID, XPath and CSS Selectors.
•	Handle dynamic web elements using appropriate waits.
•	Execute tests using TestNG.
•	Organise tests into test suites and groups.
•	Capture screenshots to assist with test failure analysis.
•	Generate test execution reports.
•	Manage dependencies and execute the project using Maven.
•	Use Git and GitHub for source-code management.
________________________________________

Technologies & Tools
Technology / Tool	Purpose
Java	Programming language
Selenium WebDriver	Web UI automation
TestNG	Test execution and test organisation
Maven	Build and dependency management
Eclipse IDE	Development environment
Git	Version control
GitHub	Source-code repository
XPath	Web element identification
CSS Selectors	Web element identification
Page Object Model	Test framework design
Chrome / WebDriver	Browser automation
________________________________________

Project Structure
SeleniumGit
│
├── .mvn/
│
├── src/
│   ├── main/
│   │   └── java/
│   │
│   └── test/
│       └── java/
│
├── testSuites/
│   └── TestNG XML files
│
├── reports/
│   └── Test execution reports
│
├── screenshots/
│   └── Test failure / execution screenshots
│
├── test-output/
│   └── TestNG execution results
│
├── pom.xml
│
└── README.md
________________________________________

Test Scenarios
The automation project covers important e-commerce user workflows such as:
1. Login
•	Navigate to the login page.
•	Enter valid user credentials.
•	Submit the login form.
•	Validate successful login/navigation.
2. Product Selection
•	Navigate through the product catalogue.
•	Identify products using Selenium locators.
•	Select the required product.
•	Interact with product-related controls.
3. Add to Cart
•	Locate the required product.
•	Select the Add To Cart option.
•	Verify that the product is added to the shopping cart.
4. Cart Validation
•	Navigate to the shopping cart.
•	Verify the selected product.
•	Validate relevant cart information.
5. Checkout / Payment
•	Continue through the checkout workflow.
•	Enter or interact with required checkout information.
•	Submit the order/payment workflow.
•	Validate the resulting page or action.
________________________________________

Automation Framework Design
The project follows a structured automation approach rather than placing all Selenium code inside a single test class.
The Page Object Model (POM) design pattern is used to separate:
•	Page locators
•	Page actions
•	Test scenarios
This makes the automation code easier to:
•	Maintain
•	Reuse
•	Debug
•	Extend
________________________________________

Selenium Locators
Different locator strategies are used depending on the structure of the application.
Examples include:
By.id("username");
By.xpath("//button[text()='Login']");
By.cssSelector(".action__submit");
The project demonstrates selecting appropriate locators based on factors such as:
•	Uniqueness
•	Stability
•	Readability
•	Maintainability
________________________________________

Synchronisation & Waits
Web applications often contain elements that are not immediately ready for interaction.
The framework therefore uses Selenium synchronisation techniques to improve test stability.
Examples include:
•	Explicit waits
•	Element visibility checks
•	Element clickability checks
•	Reusable wait methods

Example:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(
        ExpectedConditions.elementToBeClickable(element)
);
________________________________________

TestNG
TestNG is used as the test execution framework.
The project demonstrates TestNG features such as:
•	@Test
•	@BeforeMethod
•	@AfterMethod
•	@DataProvider
•	Test groups
•	Test suites
•	Assertions
________________________________________

Test Reports
Test execution results are maintained in the project through the reporting and TestNG output directories.
Reports help with:
•	Identifying passed tests
•	Identifying failed tests
•	Reviewing test execution
•	Debugging failures
Screenshots are also captured during relevant test scenarios to provide additional information when analysing failures.
________________________________________

Screenshots
The project contains a dedicated screenshots directory for storing screenshots generated during test execution.
Screenshots can be particularly useful when:
•	An element cannot be located.
•	A click operation fails.
•	A page does not load as expected.
•	An assertion fails.
•	A test unexpectedly fails.
________________________________________

Maven
The project uses Apache Maven for dependency and build management. Project dependencies are maintained in pom.xml.
Maven provides a consistent way to:
•	Download project dependencies
•	Compile the project
•	Execute tests
•	Manage plugins
•	Integrate the project with CI/CD tools
________________________________________

Prerequisites to Run the Project
Make sure the following are installed:
•	Java JDK
•	Maven
•	Eclipse IDE or another Java IDE
•	Google Chrome
•	Git

