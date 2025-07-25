package com.example.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for ApiService
 */
class ApiServiceTest {
    
    private ApiService apiService;
    
    @BeforeEach
    void setUp() {
        apiService = new ApiService();
    }
    
    @Test
    @DisplayName("Should process valid input data")
    void testProcessDataWithValidInput() {
        String input = "test data";
        String result = apiService.processData(input);
        
        assertNotNull(result);
        assertTrue(result.contains("test data"));
        assertTrue(result.contains("timestamp"));
    }
    
    @Test
    @DisplayName("Should handle null input")
    void testProcessDataWithNullInput() {
        String result = apiService.processData(null);
        
        assertNotNull(result);
        assertTrue(result.contains("input"));
        assertTrue(result.contains("timestamp"));
    }
    
    @Test
    @DisplayName("Should handle empty input")
    void testProcessDataWithEmptyInput() {
        String result = apiService.processData("");
        
        assertNotNull(result);
        assertTrue(result.contains("input"));
        assertTrue(result.contains("timestamp"));
    }
    
    @Test
    @DisplayName("Should return valid service info JSON")
    void testGetServiceInfo() {
        String serviceInfo = apiService.getServiceInfo();
        
        assertNotNull(serviceInfo);
        assertTrue(serviceInfo.contains("API Service"));
        assertTrue(serviceInfo.contains("1.0.0"));
        assertTrue(serviceInfo.contains("Active"));
    }
} 