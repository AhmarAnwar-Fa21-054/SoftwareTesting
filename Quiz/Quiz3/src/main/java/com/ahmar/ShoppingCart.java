package com.ahmar;

import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }

        if (total < 0) {
            throw new IllegalStateException("total must not be less than 0");
        }

        return total;
    }
}
