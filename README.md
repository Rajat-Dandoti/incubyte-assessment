# Incubyte-Assessment

A test automation framework for Magento e-commerce platform using Selenium WebDriver and Cucumber BDD.

## Features

- Sign Up test scenarios
- Sign In test scenarios
- Page Object Model design pattern
- Configurable browser selection (Chrome/Edge)
- Automatic unique email generation
- Cucumber HTML reporting

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/incubyte/
│   │       ├── driver_base/        # WebDriver initialization
│   │       ├── page_objects/       # Page object classes
│   │       └── utils/              # Utility classes
│   └── resources/
│       └── application.properties  # Configuration properties
└── test/
    ├── java/
    │   └── org/incubyte/
    │       ├── feature_files/      # Cucumber feature files
    │       ├── runner/             # Test runner
    │       └── step_def/           # Step definitions
    └── resources/
        └── locators/              # Element locator files
```

## Prerequisites

- Java 23
- Maven
- Chrome or Edge browser
- ChromeDriver/EdgeDriver

## Setup

1. Clone the repository
2. Install dependencies:
```sh
mvn clean install
```

## Configuration

Edit application.properties:
```properties
browser = chrome         # chrome or edge
web_driver_wait = 10    # explicit wait timeout in seconds
```

## Running Tests

Run all tests:
```sh
mvn test
```

Run specific tags:
```sh
mvn test -Dcucumber.filter.tags="@signup"  # Run only signup tests
mvn test -Dcucumber.filter.tags="@signin"  # Run only signin tests
```

## Test Reports

HTML test reports are generated at:
```
target/reports/cucumber-report.html
```

## Logging

Created user accounts are logged in:
```
created_users.log
```

## Key Components

- DriverBase: WebDriver initialization and configuration
- CommonPageObj: Common page actions
- SignUpPage: Sign up page actions and verifications
- SignInPage: Sign in page actions and verifications
- ConfigManager: Properties and locators management
- CommonUtil: Common utilities and helper methods

## Built With

- Selenium WebDriver 4.27.0
- Cucumber 7.20.1
- TestNG
- Maven
