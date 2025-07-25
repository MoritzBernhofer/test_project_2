package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple data processor that demonstrates JSON processing and logging capabilities.
 */
public class DataProcessor {
    
    private static final Logger logger = LoggerFactory.getLogger(DataProcessor.class);
    private final ObjectMapper objectMapper;
    
    public DataProcessor() {
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * Processes data by converting it to JSON format.
     * 
     * @param name the name to process
     * @param value the value to process
     * @return JSON string representation
     */
    public String processData(String name, Object value) {
        logger.info("Processing data: name={}, value={}", name, value);
        
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("value", value);
        data.put("timestamp", System.currentTimeMillis());
        
        try {
            String json = objectMapper.writeValueAsString(data);
            logger.debug("Generated JSON: {}", json);
            return json;
        } catch (JsonProcessingException e) {
            logger.error("Failed to process data to JSON", e);
            throw new RuntimeException("JSON processing failed", e);
        }
    }
    
    /**
     * Parses JSON string back to a Map.
     * 
     * @param json the JSON string to parse
     * @return parsed Map
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> parseData(String json) {
        logger.info("Parsing JSON data");
        
        try {
            Map<String, Object> result = objectMapper.readValue(json, Map.class);
            logger.debug("Parsed data: {}", result);
            return result;
        } catch (JsonProcessingException e) {
            logger.error("Failed to parse JSON data", e);
            throw new RuntimeException("JSON parsing failed", e);
        }
    }
    
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        
        // Demonstrate processing
        String json = processor.processData("example", "test value");
        System.out.println("Generated JSON: " + json);
        
        // Demonstrate parsing
        Map<String, Object> parsed = processor.parseData(json);
        System.out.println("Parsed data: " + parsed);
    }
}
