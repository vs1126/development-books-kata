package com.kata.bookapp;

import com.kata.bookapp.Service.BookPriceCalculator;
import com.kata.bookapp.dto.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookPriceCalculatorTest {

    @Test
    public void testBookNoDiscount(){
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        List<Book> books = List.of(new Book("Book 1"));
        assertEquals(50.0, bookPriceCalculator.calculatePrice(books), 0.01);
    }

    @Test
    public void testTwoDifferentBooks(){
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        List<Book> books = List.of(new Book("Book 1"), new Book("Book 2"));
        assertEquals(95.0, bookPriceCalculator.calculatePrice(books), 0.01);

    }

    @Test
    public void testThreeDifferentBooks(){
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        List<Book> books = List.of(new Book("Book 1"),
                new Book("Book 2"),
                new Book("Book 3"));
        assertEquals(135.0, bookPriceCalculator.calculatePrice(books), 0.01);
    }

    @Test
    public void testFourDifferentBooks(){
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        List<Book> books = List.of(
                new Book("Book 1"),
                new Book("Book 2"),
                new Book("Book 3"),
                new Book("Book 4"));
        assertEquals(160.0, bookPriceCalculator.calculatePrice(books), 0.01);
    }

    @Test
    public void testFiveDifferentBooks(){
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        List<Book> books = List.of(
                new Book("Book 1"),
                new Book("Book 2"),
                new Book("Book 3"),
                new Book("Book 4"),
                new Book("Book 5"));
        assertEquals(187.5, bookPriceCalculator.calculatePrice(books), 0.01);
    }


}
