package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingCartTest {

    VoucherService service;
    @BeforeEach
    void setUp() {
       service = mock(VoucherService.class);
    }

    @Test
    void itShouldApplyDiscountAndGetTotal_IfTheVoucherIsValid() {
        //Given
        Item item1 = new Item("Laptop", 450);
        Item item2 = new Item("Pen", 50);
        Item item3 = new Item("Bag", 150);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        String voucherCode = "xyz";
        double discountPercent = 40;
        //When
        ShoppingCart cart = new ShoppingCart(items,service);
        when(service.isVoucherValid(voucherCode)).thenReturn(true);
        var totalPrice = cart.applyDiscountAndGetTotal(discountPercent,voucherCode);
        //Then
        assertThat(totalPrice).isEqualTo(390);
    }
    @Test
    void itShouldNotApplyDiscountAndSimplyGetTotal_IfTheVoucherIsNotValid() {
        //Given
        Item item1 = new Item("Laptop", 450);
        Item item2 = new Item("Pen", 50);
        Item item3 = new Item("Bag", 150);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        String voucherCode = "xyy";
        double discountPercent = 40;
        //When
        ShoppingCart cart = new ShoppingCart(items,service);
        when(service.isVoucherValid(voucherCode)).thenReturn(false);
        var totalPrice = cart.applyDiscountAndGetTotal(discountPercent,voucherCode);
        //Then
        assertThat(totalPrice).isEqualTo(650);
    }
}