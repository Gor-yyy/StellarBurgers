# Stellar Burgers — UI Test Automation

## About the Project

This project contains automated UI tests for the Stellar Burgers application. The tests cover user registration, login, and navigation between sections of the burger constructor.

The project uses the Page Object pattern to separate page interactions from test logic. REST Assured is used to create and delete test users through API requests.

## What Was Tested

### User Registration
- Successful registration with a unique email address.
- Registration attempt with an invalid password.

### User Login
- Login through the **"Log in to account"** button.
- Login through the personal account button.
- Login through the registration form.
- Login through the password recovery form.

### Burger Constructor
- Navigation to the Buns section.
- Navigation to the Sauces section.
- Navigation to the Fillings section.

## Tools and Technologies

- **Java 11** — programming language.
- **Maven** — project build and dependency management.
- **Selenium WebDriver 4.35.0** — UI test automation.
- **JUnit 4.13.2** — test execution and assertions.
- **REST Assured 5.5.0** — API requests for test user setup and cleanup.
- **Allure 2.29.1** — test reporting.
- **Maven Surefire 3.5.2** — running tests through Maven.

## Project Structure

- `src/test/java/tests` — test classes and browser factory.
- `src/test/java/pages` — Page Object classes for interacting with application pages.
- `pom.xml` — project configuration, dependencies, and Maven plugins.

## Running the Tests

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Make sure the project dependencies are downloaded.
3. Open a test class.
4. Run the entire test class or an individual test.

### Using Maven

Run all tests from the project root directory:

```bash
mvn test
```

## Allure Reports

Allure test results are configured to be saved in `target/allure-results`.

To generate and open an Allure report, run:

```bash
mvn allure:serve
```

The command should be verified in your local environment to ensure that Allure reporting is configured correctly.

## Browser Support

- **Google Chrome**
- **Yandex Browser**, configured through ChromeDriver.

The login tests are parameterized to run in both browsers. The burger constructor tests support browser selection through a system property and use Chrome by default. Registration tests currently use Chrome directly.

## Test Data Management

Test users are created through API requests in the login and burger constructor tests. The tests also attempt to delete the created users after execution to help keep the test environment clean.
