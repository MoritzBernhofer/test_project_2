package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for DataProcessor functionality.
 */
class DataProcessorTest {
    
    private DataProcessor dataProcessor;
    
    @BeforeEach
    void setUp() {
        dataProcessor = new DataProcessor();
    }
    
    @Test
    void testProcessData() {
        String result = dataProcessor.processData("test", "value");
        
        assertNotNull(result);
        assertTrue(result.contains("\"name\":\"test\""));
        assertTrue(result.contains("\"value\":\"value\""));
        assertTrue(result.contains("\"timestamp\""));
    }
    
    @Test
    void testParseData() {
        String json = "{\"name\":\"test\",\"value\":\"value\",\"timestamp\":1234567890}";
        
        Map<String, Object> result = dataProcessor.parseData(json);
        
        assertNotNull(result);
        assertEquals("test", result.get("name"));
        assertEquals("value", result.get("value"));
        assertEquals(1234567890, result.get("timestamp"));
    }
    
    @Test
    void testProcessAndParseRoundTrip() {
        String originalName = "roundtrip";
        String originalValue = "test value";
        
        String json = dataProcessor.processData(originalName, originalValue);
        Map<String, Object> parsed = dataProcessor.parseData(json);
        
        assertEquals(originalName, parsed.get("name"));
        assertEquals(originalValue, parsed.get("value"));
        assertNotNull(parsed.get("timestamp"));
    }
    
    @Test
    void testInvalidJsonParsing() {
        String invalidJson = "{ invalid json }";
        
        assertThrows(RuntimeException.class, () -> {
            dataProcessor.parseData(invalidJson);
        });
    }
}
