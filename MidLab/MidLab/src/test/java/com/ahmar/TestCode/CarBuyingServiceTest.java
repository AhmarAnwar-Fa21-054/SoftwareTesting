package com.ahmar.TestCode;

import com.ahmar.Car;
import com.ahmar.CarBuyingService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarBuyingServiceTest {
    CarBuyingService underTest = new CarBuyingService();

    //T2 true true false
    @Test
    void itShouldReturnTrue_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsLessThan2_000_000OrItIsNotNew() {
        Car car = new Car(2021, 1900000, false);
        var output = underTest.shouldBuyCar(car);
        assertThat(output).isEqualTo(true);
    }

    //T3 true false true
    @Test
    void itShouldReturnTrue_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsNotLessThan2_000_000OrItIsNew() {
        Car car = new Car(2021, 2100000, true);
        var output = underTest.shouldBuyCar(car);
        assertThat(output).isEqualTo(true);
    }

    // T4 true false false
    @Test
    void itShouldReturnFalse_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsNotLessThan2_000_000OrItIsNotNew() {
        //Given  we have a Car(object) whose make year is above 2020 and price is not less than 2_000_000, or it is not new
        Car car = new Car(2021, 2100000, false);
        var output = underTest.shouldBuyCar(car);
        assertThat(output).isEqualTo(false);
    }

    // T6 false true false
    @Test
    void itShouldReturnFalse_whenWePassACarObjectWhoseMakeYearISNotAbove2020AndPriceIsLessThan2_000_000OrItIsNotNew() {
        Car car = new Car(2019, 1900000, false);
        var output = underTest.shouldBuyCar(car);
        assertThat(output).isEqualTo(false);
    }
}