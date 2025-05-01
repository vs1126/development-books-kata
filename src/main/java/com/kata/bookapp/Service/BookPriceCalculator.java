package com.kata.bookapp.Service;

import com.kata.bookapp.dto.Book;

import java.util.List;

public class BookPriceCalculator {

    public double calculatePrice(List<Book> books) {
        return books.size() * 50.0;
    }
}
