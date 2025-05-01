package com.kata.bookapp.Service;

import com.kata.bookapp.dto.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookPriceCalculator {

    private static final double BOOK_PRICE = 50.0;

    private static final Map<Integer, Double> DISCOUNT_MAP;

    static{
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 1.00);
        map.put(2, 0.95);
        map.put(3, 0.90);
        map.put(4, 0.80);
        map.put(5, 0.75);
        DISCOUNT_MAP = Collections.unmodifiableMap(map);

    };

    public String calculatePrice(List<Book> books) {

        if(books == null || books.isEmpty()) {
            return "0.0 EUR";
        }

        Map<String, Long> bookCounts = books.stream()
                .collect(Collectors.groupingBy(Book::getTitle, Collectors.counting()));

        double totalPrice = 0.0;

        while(bookCounts.values().stream().anyMatch(count -> count > 0)) {
            Set<String> groupSet = new HashSet<>();

            for(Map.Entry<String, Long> entry : bookCounts.entrySet()) {
                if(entry.getValue() > 0) {
                    groupSet.add(entry.getKey());
                    bookCounts.put(entry.getKey(), entry.getValue() - 1);
                }
            }

            int setSize = groupSet.size();
            double discountFactor = DISCOUNT_MAP.getOrDefault(setSize, 1.0);
            totalPrice += setSize * BOOK_PRICE * discountFactor;
        }

        return String.valueOf(totalPrice)+ " EUR";
    }
}
