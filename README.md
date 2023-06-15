# e2e-testing-starter

This repository includes a minimal starter for doing End-to-End web testing with Selenium, JUnit 5, and Hamcrest.

## Requirements
* A modern web browser (Firefox recommended)
* Java 8 or above (Java 17 recommended)
* Maven 3.8.1 or above should be in the system path (if you want to run the tests using the Maven command instead of the IDE)

## Instructions
1. Clone the repository as a Maven project in your IDE.
2. Install the Maven dependencies.
3. Run the `ExampleTest` class to check that everything is working. You can do that by running the class from within your IDE, or by running the `mvn test` command from the root directory. A single End-to-End test should be executed on the DuckDuckGo website.

## Notes
The example uses Firefox. You can experiment with other browsers on your system by uncommenting the lines corresponding 
to the web browser of choice in the `setup()` and `setupWebDriver()` methods in the `ExampleTest` class.
