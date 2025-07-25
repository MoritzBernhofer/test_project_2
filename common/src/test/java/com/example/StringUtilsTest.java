package com.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for StringUtils module.
 * Demonstrates testing with Apache Commons Lang dependency.
 */
@DisplayName("StringUtils Tests")
class StringUtilsTest {

    @Test
    @DisplayName("Should detect blank strings correctly")
    void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank("   "));
        assertFalse(StringUtils.isBlank("hello"));
        assertFalse(StringUtils.isBlank("  hello  "));
    }

    @Test
    @DisplayName("Should detect non-blank strings correctly")
    void testIsNotBlank() {
        assertFalse(StringUtils.isNotBlank(null));
        assertFalse(StringUtils.isNotBlank(""));
        assertFalse(StringUtils.isNotBlank("   "));
        assertTrue(StringUtils.isNotBlank("hello"));
        assertTrue(StringUtils.isNotBlank("  hello  "));
    }

    @Test
    @DisplayName("Should capitalize strings correctly")
    void testCapitalize() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("World", StringUtils.capitalize("world"));
        assertEquals("", StringUtils.capitalize(""));
        assertNull(StringUtils.capitalize(null));
        assertEquals("  hello", StringUtils.capitalize("  hello"));
    }

    @Test
    @DisplayName("Should reverse strings correctly")
    void testReverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("dlrow", StringUtils.reverse("world"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
        assertEquals("  olleh", StringUtils.reverse("hello  "));
    }

    @Test
    @DisplayName("Should generate random strings of correct length")
    void testGenerateRandomString() {
        String random1 = StringUtils.generateRandomString(10);
        String random2 = StringUtils.generateRandomString(15);
        
        assertEquals(10, random1.length());
        assertEquals(15, random2.length());
        assertNotEquals(random1, random2);
        
        // Check that it contains only alphanumeric characters
        assertTrue(random1.matches("[a-zA-Z0-9]+"));
        assertTrue(random2.matches("[a-zA-Z0-9]+"));
    }

    @Test
    @DisplayName("Should escape HTML correctly")
    void testEscapeHtml() {
        String html = "<script>alert('test')</script>";
        String escaped = StringUtils.escapeHtml(html);
        
        // Debug: print the escaped string
        System.out.println("Original: " + html);
        System.out.println("Escaped: " + escaped);
        
        // Check that the escaped string is different from original
        assertNotEquals(html, escaped);
        
        // Test unescaping
        String unescaped = StringUtils.unescapeHtml(escaped);
        assertEquals(html, unescaped);
    }

    @Test
    @DisplayName("Should join strings correctly")
    void testJoin() {
        List<String> words = List.of("apple", "banana", "cherry");
        String result = StringUtils.join(words, ", ");
        assertEquals("apple, banana, cherry", result);
        
        // Test empty list
        assertEquals("", StringUtils.join(List.of(), ", "));
        
        // Test null list
        assertEquals("", StringUtils.join(null, ", "));
    }

    @Test
    @DisplayName("Should split and trim strings correctly")
    void testSplitAndTrim() {
        String input = "  apple , banana , cherry  ";
        List<String> result = StringUtils.splitAndTrim(input, ",");
        
        assertEquals(3, result.size());
        assertEquals("apple", result.get(0));
        assertEquals("banana", result.get(1));
        assertEquals("cherry", result.get(2));
        
        // Test empty string
        assertTrue(StringUtils.splitAndTrim("", ",").isEmpty());
        
        // Test null string
        assertTrue(StringUtils.splitAndTrim(null, ",").isEmpty());
    }

    @Test
    @DisplayName("Should count occurrences correctly")
    void testCountOccurrences() {
        String text = "hello hello world hello";
        assertEquals(3, StringUtils.countOccurrences(text, "hello"));
        assertEquals(1, StringUtils.countOccurrences(text, "world"));
        assertEquals(0, StringUtils.countOccurrences(text, "missing"));
        
        // Test with empty strings
        assertEquals(0, StringUtils.countOccurrences("", "hello"));
        assertEquals(0, StringUtils.countOccurrences("hello", ""));
        assertEquals(0, StringUtils.countOccurrences(null, "hello"));
        assertEquals(0, StringUtils.countOccurrences("hello", null));
    }

    @Test
    @DisplayName("Should handle edge cases gracefully")
    void testEdgeCases() {
        // Test with very long strings
        String longString = "a".repeat(1000);
        assertEquals(1000, StringUtils.countOccurrences(longString, "a"));
        
        // Test with special characters
        String special = "!@#$%^&*()";
        assertEquals(special, StringUtils.reverse(StringUtils.reverse(special)));
        
        // Test with unicode characters
        String unicode = "café résumé";
        assertTrue(StringUtils.isNotBlank(unicode));
        assertEquals("Café résumé", StringUtils.capitalize(StringUtils.reverse(StringUtils.reverse("café résumé"))));
    }
} 