# Stellar Burgers — UI Test Automation

## About the Project

This project contains automated UI tests for the Stellar Burgers application. The goal is to verify key user scenarios, including registration, login, and navigation between sections of the burger constructor.

The project follows the Page Object pattern to separate page interactions from test logic. REST Assured is used to create and delete test users through API requests, allowing test data to be prepared and cleaned up automatically.

## Test Scenarios

### User Registration
- Successful registration using a unique email address.
- Registration attempt with an invalid password.

### User Login
- Login through the "Log in to account" button.
- Login through the personal account button.
- Login through the registration form.
- Login through the password recovery form.

### Burger Constructor
- Navigation to the Buns section.
- Navigation to the Sauces section.
- Navigation to the Fillings section.

## Technologies and Dependencies

| Technology | Version | Purpose |
|---|---|---|
| Java | 11 | Programming language |
| Maven | — | Build automation and dependency management |
| Selenium WebDriver | 4.35.0 | Browser automation |
| JUnit | 4.13.2 | Test execution and assertions |
| REST Assured | 5.5.0 | API requests for test data management |
| Allure | 2.29.1 | Test reporting |
| Jackson Databind | 2.17.2 | JSON processing |
| Maven Surefire | 3.5.2 | Running tests through Maven |
| Allure Maven Plugin | 2.12.0 | Allure report generation |

Project dependencies and plugin configurations are defined in `pom.xml`.

## System Requirements

- Java Development Kit (JDK) 11.
- Apache Maven.
- IntelliJ IDEA or another Java IDE.
- Google Chrome for browser tests.
- A compatible ChromeDriver setup.
- Yandex Browser if running the parameterized login tests in Yandex Browser.

An internet connection is required to download Maven dependencies and access the test application and its API.

## Project Structure

```text
StellarBurgers/
├── src/
│   └── test/
│       └── java/
│           ├── pages/       # Page Object classes
│           └── tests/       # UI test classes and browser factory
├── pom.xml                  # Dependencies and build configuration
└── README.md
```

## Running the Tests

### Using IntelliJ IDEA

1. Clone the repository and open the project in IntelliJ IDEA.
2. Make sure JDK 11 is selected as the project SDK.
3. Wait for Maven to download the dependencies.
4. Open a test class.
5. Run the test class or an individual test.

### Using Maven

Run all tests from the project root directory:

```bash
mvn test
```

## Browser Configuration

The project supports Google Chrome and Yandex Browser.

- Login tests are parameterized to run in both browsers.
- Burger constructor tests use Chrome by default. The browser can be selected through the `browser` system property.
- Registration tests currently use Chrome directly.

The browser and driver versions must be compatible with the local environment.

## Allure Test Reports

Allure results are configured to be saved in:

```text
target/allure-results
```

After running the tests, try generating and opening the report with:

```bash
mvn allure:serve
```

The command depends on the local Allure Maven Plugin configuration and the availability of the required Allure tools.

## Test Data Management

The login and burger constructor tests create test users through API requests and attempt to delete them after execution. This helps reduce leftover test data.

The registration tests use a unique email address for successful registration scenarios.

## Project Summary

This project demonstrates practical experience in Java UI test automation, organizing tests with the Page Object pattern, parameterizing tests across browsers, and using API requests to manage test data.

The automated scenarios cover key registration and login flows and navigation between burger constructor sections. Allure integration is configured to collect test results for reporting.
