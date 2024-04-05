package com.ahmar;

public class CarBuyingService {
    public boolean shouldBuyCar(Car car) {

        if ((car.getMakeYear() > 2020 && car.getPrice() < 2_000_000) || car.isNew()) {
            return true;
        }

        return false;
    }
}
