package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enhanced string utilities that extend Apache Commons Lang functionality.
 * This module demonstrates the use of external dependencies with version properties.
 */
public class StringUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);
    
    /**
     * Checks if a string is blank (null, empty, or whitespace only).
     * 
     * @param str the string to check
     * @return true if the string is blank
     */
    public static boolean isBlank(String str) {
        return org.apache.commons.lang3.StringUtils.isBlank(str);
    }
    
    /**
     * Checks if a string is not blank.
     * 
     * @param str the string to check
     * @return true if the string is not blank
     */
    public static boolean isNotBlank(String str) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(str);
    }
    
    /**
     * Capitalizes the first character of a string.
     * 
     * @param str the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String str) {
        if (isBlank(str)) {
            return str;
        }
        logger.debug("Capitalizing string: {}", str);
        return org.apache.commons.lang3.StringUtils.capitalize(str);
    }
    
    /**
     * Reverses a string.
     * 
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverse(String str) {
        if (isBlank(str)) {
            return str;
        }
        logger.debug("Reversing string: {}", str);
        return org.apache.commons.lang3.StringUtils.reverse(str);
    }
    
    /**
     * Generates a random alphanumeric string of specified length.
     * 
     * @param length the length of the string to generate
     * @return a random alphanumeric string
     */
    public static String generateRandomString(int length) {
        logger.debug("Generating random string of length: {}", length);
        return RandomStringUtils.randomAlphanumeric(length);
    }
    
    /**
     * Escapes HTML entities in a string.
     * 
     * @param str the string to escape
     * @return the escaped string
     */
    public static String escapeHtml(String str) {
        if (isBlank(str)) {
            return str;
        }
        logger.debug("Escaping HTML in string: {}", str);
        return StringEscapeUtils.escapeHtml4(str);
    }
    
    /**
     * Unescapes HTML entities in a string.
     * 
     * @param str the string to unescape
     * @return the unescaped string
     */
    public static String unescapeHtml(String str) {
        if (isBlank(str)) {
            return str;
        }
        logger.debug("Unescaping HTML in string: {}", str);
        return StringEscapeUtils.unescapeHtml4(str);
    }
    
    /**
     * Joins a list of strings with a delimiter.
     * 
     * @param strings the list of strings to join
     * @param delimiter the delimiter to use
     * @return the joined string
     */
    public static String join(List<String> strings, String delimiter) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }
        logger.debug("Joining {} strings with delimiter: {}", strings.size(), delimiter);
        return org.apache.commons.lang3.StringUtils.join(strings, delimiter);
    }
    
    /**
     * Splits a string and trims each part.
     * 
     * @param str the string to split
     * @param delimiter the delimiter to split on
     * @return list of trimmed strings
     */
    public static List<String> splitAndTrim(String str, String delimiter) {
        if (isBlank(str)) {
            return List.of();
        }
        logger.debug("Splitting and trimming string: {}", str);
        return Arrays.asList(org.apache.commons.lang3.StringUtils.split(str, delimiter))
                .stream()
                .map(String::trim)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }
    
    /**
     * Counts the occurrences of a substring in a string.
     * 
     * @param str the string to search in
     * @param sub the substring to count
     * @return the number of occurrences
     */
    public static int countOccurrences(String str, String sub) {
        if (isBlank(str) || isBlank(sub)) {
            return 0;
        }
        logger.debug("Counting occurrences of '{}' in '{}'", sub, str);
        return org.apache.commons.lang3.StringUtils.countMatches(str, sub);
    }
    
    /**
     * Demonstrates the utility methods.
     */
    public static void main(String[] args) {
        logger.info("StringUtils demonstration");
        
        // Test basic operations
        String test = "  hello world  ";
        System.out.println("Original: '" + test + "'");
        System.out.println("Is blank: " + isBlank(test));
        System.out.println("Capitalized: '" + capitalize(test.trim()) + "'");
        System.out.println("Reversed: '" + reverse(test.trim()) + "'");
        
        // Test random string generation
        String random = generateRandomString(10);
        System.out.println("Random string: " + random);
        
        // Test HTML escaping
        String html = "<script>alert('test')</script>";
        String escaped = escapeHtml(html);
        System.out.println("HTML escaped: " + escaped);
        System.out.println("HTML unescaped: " + unescapeHtml(escaped));
        
        // Test joining and splitting
        List<String> words = List.of("apple", "banana", "cherry");
        String joined = join(words, ", ");
        System.out.println("Joined: " + joined);
        
        String toSplit = "  apple , banana , cherry  ";
        List<String> split = splitAndTrim(toSplit, ",");
        System.out.println("Split and trimmed: " + split);
        
        // Test counting
        String text = "hello hello world hello";
        System.out.println("Occurrences of 'hello': " + countOccurrences(text, "hello"));
    }
} 