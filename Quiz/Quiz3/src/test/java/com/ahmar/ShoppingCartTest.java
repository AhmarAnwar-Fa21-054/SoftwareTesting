package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    void itShouldReturnTotalPriceOfItemsInTheCart_WhenPriceOfAllTheItemsInTheCartIsPositive() {
        //Given
        Item item1 = new Item("Laptop", 450);
        Item item2 = new Item("Pen", 50);
        Item item3 = new Item("Bag", 150);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        //When
        ShoppingCart cart = new ShoppingCart(items);
        var actualTotalPrice = cart.getTotal();
        //Then
        assertThat(actualTotalPrice).isEqualTo(650);
    }
    @Test
    void itShouldThrowIllegalStateException_WhenTotalPriceOfItemsInTheCartIsNegative() {
        //Given
        Item item1 = new Item("Laptop", -450);
        Item item2 = new Item("Pen", 50);
        Item item3 = new Item("Bag", 150);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        //When & Then
        ShoppingCart cart = new ShoppingCart(items);
      var exception =   assertThrows(IllegalStateException.class,()->cart.getTotal());
      assertThat(exception.getMessage()).isEqualTo("total must not be less than 0");
    }

}