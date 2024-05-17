package com.ahmar;
import java.util.List;
public class ShoppingCart {
    private List<Item> items;
    private VoucherService voucherService;

    public ShoppingCart(List<Item> items, VoucherService voucherService) {
        this.items = items;
        this.voucherService = voucherService;
    }

    public double getTotal() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }

        if (total < 0) {
            throw new IllegalStateException("total cannot be less than 0");
        }

        return total;
    }

    public double applyDiscountAndGetTotal(double discountPercent, String voucherCode) {
        double total = getTotal();

        boolean isValid = voucherService.isVoucherValid(voucherCode);

        if (isValid) {
            total = total - (total * discountPercent/100);
        }

        return total;
    }
}
