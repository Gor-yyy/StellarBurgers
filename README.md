# Stellar Burgers — API Test Automation

## About the Project

This project contains automated API tests for the Stellar Burgers application, developed as part of the Yandex Practicum QA Automation Engineer training program.

The goal was to verify API endpoints related to user registration, authentication, and order creation.

## What Was Tested

### User Registration
- Registration of a unique user.
- Registration of an already existing user.
- Registration with a missing required field.

### User Login
- Login with valid credentials.
- Login with an incorrect username or password.

### Order Creation
- Creating an order as an authenticated user.
- Creating an order without authentication.
- Creating an order with ingredients.
- Creating an order without ingredients.
- Creating an order with an invalid ingredient hash.

## Tools and Technologies

- Java
- Maven
- JUnit 4
- REST Assured
- Allure

