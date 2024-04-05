package com.ahmar.BDDTestCases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarBuyingServiceTest {
//MC/DC Coverage Criteria
    // car.getMakeYear() > 2020
    // For car.getMakeYear() > 2020, we pick T2,T6 from the Truth Table as it is an independence pair meaning if we change the value of the condition
    // i.e., car.getMakeYear() > 2020 and keep other two conditions same in both the test cases then we can see the outcome of both the test cases is
    // different meaning  car.getMakeYear() > 2020 is effecting the entire decision in T2 and T6....

    // car.getPrice() < 2_000_000
    // For car.getPrice() < 2_000_000, we pick T2,T4 from the Truth Table as it is an independence pair meaning if we change the value of the condition
    // i.e., car.getPrice() < 2_000_000 and keep other two conditions same in both the test cases then we can see the outcome of both the test cases is
    // different meaning  car.getPrice() < 2_000_000 is effecting the entire decision in T2 and T4....

    // car.isNew()
    // For car.isNew(), we pick T3,T4 and T5,T6 and T7,T8 from the Truth Table as they are the pairs what we called as independence pairs meaning if we change the value of the condition
    // i.e., car.isNew() and keep other two conditions same in both the test cases(T3,T4 or T5,T6 or T7,T8) then we can see the outcome of both the test cases(T3,T4 or T5,T6 or T7,T8) is
    // different meaning  car.isNew() is effecting the entire decision in T3,T4 or T5,T6 or T7,T8 ....

    // According to MC/DC coverage criteria we can reduce our test cases to N(number of conditions in the decision) + 1 by selecting one independence pair per variable or parameter
    // For  car.getMakeYear() > 2020 and car.getPrice() < 2_000_000 we have have no choice which one to select or which one not, as for both of them we have
    // only one independence pairs per condition but for car.isNew() we have three independence pairs , so we have to select that one pair that
    // results in total N+1 test cases
    //Thus, from car.getMakeYear() > 2020 we have T2,T6
    // from car.getPrice() < 2_000_000 we have T2,T4
    // from car.isNew() we pick T3,T4 or T5,T6
    // N+1 test cases = {T2,T6,T4,T3 or T5 (your choice)}


    //BDD TestCases
//T2 true true false
    @Test
    void itShouldReturnTrue_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsLessThan2_000_000OrItIsNotNew() {
        //Given we have a Car(object) whose make year is above 2020 and price is less than 2_000_000, or it is not new
        //When we pass that Car object to "shouldBuyCar" method
        //Then it should return true
    }

    //T3 true false true
    @Test
    void itShouldReturnTrue_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsNotLessThan2_000_000OrItIsNew() {
        //Given we have a Car(object) whose make year is above 2020 and price is not less than 2_000_000, or it is new
        //When  we pass that Car object to "shouldBuyCar" method
        //Then  it should return true
    }

    // T4 true false false
    @Test
    void itShouldReturnFalse_whenWePassACarObjectWhoseMakeYearISAbove2020AndPriceIsNotLessThan2_000_000OrItIsNotNew() {
        //Given  we have a Car(object) whose make year is above 2020 and price is not less than 2_000_000, or it is not new
        //When  we pass that Car object to "shouldBuyCar" method
        //Then  it should return true
    }

    // T6 false true false
    @Test
    void itShouldReturnFalse_whenWePassACarObjectWhoseMakeYearISNotAbove2020AndPriceIsLessThan2_000_000OrItIsNotNew() {
        //Given  we have a Car(object) whose make year is not above 2020 and price is less than 2_000_000, or it is not new
        //When  we pass that Car object to "shouldBuyCar" method
        //Then  it should return true
    }
}