package com.kata.bookapp.Service;

import com.kata.bookapp.dto.Book;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookPriceCalculator {

    public double calculatePrice(List<Book> books) {

        double bookPrice = 50.0;

        Set<String> uniqueBookTitles = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());

        int differentBooks = uniqueBookTitles.size();
        int totalBooks = books.size();

        double totalPrice = totalBooks * bookPrice;

        if(differentBooks == 2) {
            totalPrice *= 0.95; // 5% discount
        } else if(differentBooks == 3) {
            totalPrice *= 0.90; //10% discount
        } else if(differentBooks == 4) {
            totalPrice *= 0.80; //20% discount
        } else if(differentBooks == 5) {
            totalPrice *= 0.75; // 25% discount
        }


        return totalPrice;
    }
}
