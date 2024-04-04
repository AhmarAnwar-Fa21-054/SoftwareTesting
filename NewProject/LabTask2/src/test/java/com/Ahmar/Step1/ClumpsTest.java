package com.Ahmar.Step1;

import com.Ahmar.Clumps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClumpsTest {
    Clumps underTest = new Clumps();
    @Test
    void itShouldReturnZeroNumberOfClumps_WhenWePassAnArrayOfIntTypeThatIsNullTocountClumps() {
        //Given that we have an array of int type that contains null
        int[] anArray = null;
        //When we pass that array to countClumps method
        var output = underTest.countClumps(anArray);
        //Then it should return 0 number of clumps
        assertThat(output).isEqualTo(0);
    }
    @Test
    void itShouldReturnZeroNumberOfClumps_WhenWePassAnArrayOfIntTypeThatIsEmptyTocountClumps() {
        //Given that we have an array of int type that is empty
        int[] anArray = new int[]{};
        //When we pass that array to countClumps method
        var output = underTest.countClumps(anArray);
        //Then it should return 0 number of clumps
        assertThat(output).isEqualTo(0);
    }
    @Test
    void itShouldReturnOneAsNumberOfClumps_WhenWePassAnArrayOfIntTypeThatContainsOneClumpTocountClumps() {
        //Given that we have an array of int type that contains one clump like [1,2,3,3,4,5]
        int[] anArray = new int[]{1,2,3,3,4,5};
        //When we pass that array to countClumps method
        var output = underTest.countClumps(anArray);
        //Then it should return 1 as number of clumps
        assertThat(output).isEqualTo(1);
    }
    @Test
    void itShouldReturnTwoAsNumberOfClumps_WhenWePassAnArrayOfIntTypeThatContainsTwoClumpsTocountClumps() {
        //Given that we have an array of int type that contains two clumps like [1,2,3,3,4,4,5]
        int[] anArray = new int[]{1,2,3,3,4,4,5};
        //When we pass that array to countClumps method
        var output = underTest.countClumps(anArray);
        //Then it should return 2 as number of clumps
        assertThat(output).isEqualTo(2);
    }
}