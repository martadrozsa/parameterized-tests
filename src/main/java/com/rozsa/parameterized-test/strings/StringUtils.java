package com.rozsa.parameterizedtest.strings;

public class StringUtils {
    public boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
