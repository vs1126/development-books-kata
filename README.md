# Development Books

This is a Java based solution to Software Development Books - https://stephane-genicot.github.io/katas/DevelopmentBooks.html.
The goal is to implement a price calculator that applies discounts based on sets of different books purchased.

## Problem Statemnet

There are 5 different books available. Each book costs 50 EUR. Discounts are applied when you purchase different titles together:

- 2 different books: 5% discount
- 3 different books: 10% discount
- 4 different books: 20% discount
- 5 different books: 25% discount

If multiple copies of the same book are purchased, the system optimally group them to maximize the discount.

## Project Structure

- **BookPriceCalculator.java**: Main Service class - Logic to calculate the total price with discounts.
- **BookPriceCalculatorTest.java**: JUnit test class with 7 test cases covering different scenarios and edge cases.

## Tech Stack

-Java 8
-Maven
-Junit

## How to Run

1. Clone this repository:
    ```bash git clone https://github.com/vs1126/development-books-kata.git
       cd development-books-kata
   ```
2. Run the tests using Maven:
    ```bash
    mvn clean test
   ```
3. You should see all 7 test cases pass successfully.