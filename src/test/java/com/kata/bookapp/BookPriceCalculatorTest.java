package com.kata.bookapp;

import com.kata.bookapp.Service.BookPriceCalculator;
import com.kata.bookapp.dto.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookPriceCalculatorTest {

    private final BookPriceCalculator calculator = new BookPriceCalculator();

    private Book book(String title) {
        return new Book(title);
    }

    @Test
    public void testEmptyBasket(){
        assertEquals("0.0 EUR", calculator.calculatePrice(Collections.emptyList()));
    }

    @Test
    public void testSingleBook(){
        assertEquals("50.0 EUR", calculator.calculatePrice(Collections.singletonList(book("Clean Code"))));
    }

    @Test
    public void testTwoDifferentBooks(){
        List<Book> books = Arrays.asList(
                book("Clean Code"),
                book("Clean Architecture")
        );
        assertEquals("95.0 EUR", calculator.calculatePrice(books));

    }

    @Test
    public void testThreeDifferentBooks(){
        List<Book> books = Arrays.asList(
                book("Clean Code"),
                book("Clean Architecture"),
                book("Legacy Code")
        );
        assertEquals("135.0 EUR", calculator.calculatePrice(books));
    }

    @Test
    public void testFourDifferentBooks(){
        List<Book> books = Arrays.asList(
                book("Clean Code"),
                book("Clean Architecture"),
                book("Legacy Code"),
                book("TDD by Example")
        );
        assertEquals("160.0 EUR", calculator.calculatePrice(books));
    }

    @Test
    public void testFiveDifferentBooks(){
        List<Book> books = Arrays.asList(
                book("Clean Code"),
                book("Clean Architecture"),
                book("Legacy Code"),
                book("TDD by Example"),
                book("Refactoring")
        );
        assertEquals("187.5 EUR", calculator.calculatePrice(books));
    }

    @Test
    public void testMultipleCopiesOfMultipleBooks(){
        List<Book> books = Arrays.asList(
                book("Clean Code"), book("Clean Code"),
                book("Clean Architecture"),
                book("Legacy Code"), book("Legacy Code"),
                book("TDD by Example"),
                book("Refactoring")
        );

        double expectedPrice = (5 * 50 * 0.75) + (2 * 50 * 0.95); //5 different books(25%) & 2 diff books(5%)
        assertEquals(String.valueOf(expectedPrice) + " EUR", calculator.calculatePrice(books));
    }

    @Test
    public void testMultipleCopiesOfMultipleBooks1(){
        List<Book> books = Arrays.asList(
                book("Clean Code"), book("Clean Code"),
                book("Clean Architecture"),
                book("Legacy Code"), book("Legacy Code"),
                book("TDD by Example"),
                book("Refactoring")
        );

        double expectedPrice = (5 * 50 * 0.75) + (2 * 50 * 0.95); //5 different books(25%) & 2 diff books(5%)
        assertEquals(String.valueOf(expectedPrice) + " EUR", calculator.calculatePrice(books));
    }


}
