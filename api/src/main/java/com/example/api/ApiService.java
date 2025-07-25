package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.DataProcessor;
import com.example.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * API Service that demonstrates the use of common module utilities
 */
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    
    private final DataProcessor dataProcessor;
    private final StringUtils stringUtils;
    private final ObjectMapper objectMapper;
    
    public ApiService() {
        this.dataProcessor = new DataProcessor();
        this.stringUtils = new StringUtils();
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * Process data using common utilities
     * @param input The input data to process
     * @return Processed result
     */
    public String processData(String input) {
        logger.info("Processing data: {}", input);
        
        // Use common module utilities
        String cleanedInput = StringUtils.isNotBlank(input) ? input.trim() : "";
        String processedData = dataProcessor.processData("input", cleanedInput);
        
        logger.info("Data processing completed");
        return processedData;
    }
    
    /**
     * Get service information
     * @return Service information as JSON string
     */
    public String getServiceInfo() {
        try {
            ServiceInfo info = new ServiceInfo("API Service", "1.0.0", "Active");
            return objectMapper.writeValueAsString(info);
        } catch (Exception e) {
            logger.error("Error serializing service info", e);
            return "{\"error\": \"Failed to get service info\"}";
        }
    }
    
    /**
     * Inner class for service information
     */
    public static class ServiceInfo {
        private String name;
        private String version;
        private String status;
        
        public ServiceInfo(String name, String version, String status) {
            this.name = name;
            this.version = version;
            this.status = status;
        }
        
        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getVersion() { return version; }
        public void setVersion(String version) { this.version = version; }
        
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
} 