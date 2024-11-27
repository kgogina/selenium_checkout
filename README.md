# Selenium Checkout Test Project

## Overview
This project is a functional test suite for a web application written in **Java** using Java version `1.8.0_271`. The test implements the Page Object Model (POM) design pattern.

The `src` folder contains two packages:
1. **`pages` Package**:
   - Contains the Page Object classes that represent the different pages of the application:
     - **`LoginPage`**: Handles user login functionality.
     - **`ProductsPage`**: Handles adding products to the cart.
     - **`CartPage`**: Handles cart-related actions.
     - **`CheckoutPage`**: Handles the checkout process.
   
2. **`tests` Package**:
   - Contains the test class:
     - **`SaucedemoTest`**: Runs the test by triggering the methods defined in the `pages` package.

Additionally, a file named **`selenium_checkout_one_page_java`** is included for testing purposes. This file contains all the logic within a single class, which may be helpful for running the tests if there are any issues with the packages.

---

## Prerequisites
- **Java Development Kit (JDK)**: Version `1.8.0_271` or higher.
