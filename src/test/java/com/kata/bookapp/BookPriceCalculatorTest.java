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
}
