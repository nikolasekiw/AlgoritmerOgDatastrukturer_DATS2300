package Forelesninger;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Week1Test {
    @org.junit.jupiter.api.Test
    void findMax() {
        int[] values = {1, 2, 3, 4, 5};

        assertEquals(Week1.findMax(values), 5);
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
        int[] values = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(values));
        System.out.println(Week1.toString(values));

        assertEquals(Week1.toString(values), Arrays.toString(values));
    }

    @Test
    void findMaximumPositive(){
        int[] values = {9, 17, 11, 4, 8, 32, 64};
        int max_value = Week1.findMax(values);

        assertEquals(64, max_value);
    }

    @Test
    void findMaximumNegative(){
        int[] values = {-9, -17, -11, -4, -8, -32, -64};
        int max_value = Week1.findMax(values);

        assertEquals(-4, max_value);
    }
}