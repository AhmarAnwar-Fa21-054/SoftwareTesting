package com.Ahmar.Step0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClumpsTest {
    @Test
    void itShouldReturnZeroNumberOfClumps_WhenWePassAnArrayOfIntTypeThatIsNullTocountClumps() {
        //Given that we have an array of int type that contains null
        //When we pass that array to countClumps method
        //Then it should return 0 number of clumps
    }
    @Test
    void itShouldReturnZeroNumberOfClumps_WhenWePassAnArrayOfIntTypeThatIsEmptyTocountClumps() {
        //Given that we have an array of int type that is empty
        //When we pass that array to countClumps method
        //Then it should return 0 number of clumps
    }
    @Test
    void itShouldReturnOneAsNumberOfClumps_WhenWePassAnArrayOfIntTypeThatContainsOneClumpTocountClumps() {
        //Given that we have an array of int type that contains one clump like [1,2,3,3,4,5]
        //When we pass that array to countClumps method
        //Then it should return 1 as number of clumps
    }
    @Test
    void itShouldReturnTwoAsNumberOfClumps_WhenWePassAnArrayOfIntTypeThatContainsTwoClumpsTocountClumps() {
        //Given that we have an array of int type that contains two clumps like [1,2,3,3,4,4,5]
        //When we pass that array to countClumps method
        //Then it should return 2 as number of clumps
    }






}
