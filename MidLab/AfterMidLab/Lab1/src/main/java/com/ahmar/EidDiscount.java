package com.ahmar;

import java.time.LocalDate;
import java.time.Month;

public class EidDiscount {


    private final Clock clock;

    public EidDiscount(Clock clock) { // passing dependency from outside
        this.clock = clock;

    }

    public double applyDiscount(double rawAmount) {
        LocalDate today = clock.now(); //2024-06-17
//LocalDate today = LocalDate.of(2024,6,17); //2024-06-17 //creating own dependency
        double discountPercentage = 0;
        boolean isEid = today.getMonth() == Month.JUNE && today.getDayOfMonth() == 17;

        if (isEid) discountPercentage = 0.15;

        return rawAmount - (rawAmount * discountPercentage);
    }
}

