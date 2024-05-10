package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {
CalculatorService calculatorService;
Calculator fakeCalculator;
    @BeforeEach
    void setUp() {
//        calculator = new ConcreteCalculator();
        fakeCalculator = mock(Calculator.class);

        calculatorService = new CalculatorService(fakeCalculator);
    }

    @Test
    void itShouldReturn5_WhenWePass2and3() {

        //Given
        int a = 2; int b = 3;
        when(fakeCalculator.add(a,b)).thenReturn(5);
        when(fakeCalculator.add(4,9)).thenReturn(5);
        //When
        var output = calculatorService.performAddition(a,b);
        verify(fakeCalculator).add(4,9);

        //Then
        assertThat(output).isEqualTo(5);
    }
}