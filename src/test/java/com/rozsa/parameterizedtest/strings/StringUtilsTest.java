package com.rozsa.parameterizedtest.strings;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    private static StringUtils stringUtils;

    @BeforeAll
    static void setup() {
        stringUtils = new StringUtils();
    }
    @ParameterizedTest
    @ValueSource(strings = {"level", "madam", "ded", "kayak"})
    void isPalindrome(String word) {
        assertTrue(stringUtils.isPalindrome(word));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertNull(input);
    }

    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertEquals("", input);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }
}
