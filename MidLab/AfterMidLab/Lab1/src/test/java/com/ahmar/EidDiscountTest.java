package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EidDiscountTest {
    EidDiscount underTest;
   Clock Fakeclock;

    @BeforeEach
    public void setUp() {
//        Clock clock = new Clock();
        Fakeclock = mock(Clock.class);
        underTest = new EidDiscount(Fakeclock);
    }

    @Test
    void itShouldReturn85RsIfItIsEid_WhenWePass100RS() {

        when(Fakeclock.now()).thenReturn(LocalDate.of(2024,6,17)); //2024-06-17
        //Given
        var price = 100;
        //When
        var output = underTest.applyDiscount(price);
        verify(Fakeclock).now();
        //Then
        assertThat(output).isEqualTo(85);
    }

    @Test
    void itShouldReturn100RsIfItIsNotEid_WhenWePass100RS() {

        when(Fakeclock.now()).thenReturn(LocalDate.of(2024,6,18)); //2024-06-17
        //Given
        var price = 100;
        //When
        var output = underTest.applyDiscount(price);
        verify(Fakeclock).now();
        //Then
        assertThat(output).isEqualTo(100);
    }
}