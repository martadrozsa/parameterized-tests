package com.rozsa.parameterizedtest.month;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class EnumTest {

    private static Calendar calendar;

    @BeforeAll
    static void setup() {
        calendar = new Calendar();
    }
    @ParameterizedTest
    @EnumSource(Month.class)
    void testWith_EnumSource(Month month) {
        String expected = String.format("The month received was %s", month);
        String res =  calendar.printMonth(month);

        assertEquals(expected, res);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"JANUARY", "MAY"})
    void testWith_EnumSource_include(Month month) {
        String expected = String.format("The month received was %s", month);
        String res =  calendar.printMonth(month);

        assertEquals(expected, res);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, mode = EnumSource.Mode.EXCLUDE, names = {"JANUARY", "MAY"})
    void testWith_EnumSource_exclude(Month month) {
        String expected = String.format("The month received was %s", month);

        String res =  calendar.printMonth(month);

        assertEquals(expected, res);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, mode = EnumSource.Mode.MATCH_ALL, names = "^.*BER$")
    void testWith_EnumSource_Regex(Month month) {
        String expected = String.format("The month received was %s", month);

        String res =  calendar.printMonth(month);

        assertEquals(expected, res);
    }

}
