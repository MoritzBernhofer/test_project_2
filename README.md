# Test Project 2

A simple Maven project designed to test dependency analysis capabilities.

## Dependencies

This project uses several dependencies to demonstrate dependency analysis:

- **Jackson Databind** (`com.fasterxml.jackson.core:jackson-databind:${jackson.version}`) - JSON processing
- **Apache Commons Lang** (`org.apache.commons:commons-lang3:${commons-lang.version}`) - String utilities
- **SLF4J API** (`org.slf4j:slf4j-api:2.0.7`) - Logging interface  
- **Logback Classic** (`ch.qos.logback:logback-classic:1.4.11`) - Logging implementation
- **JUnit Jupiter** (`org.junit.jupiter:junit-jupiter:5.10.0`) - Testing framework (test scope)

### Version Properties

The project uses Maven properties for version management:
- `${jackson.version}` = 2.15.2
- `${commons-lang.version}` = 3.12.0

## Build Plugins

- **Maven Compiler Plugin** (`maven-compiler-plugin:3.11.0`) - Java 17 compilation
- **Maven Surefire Plugin** (`maven-surefire-plugin:3.1.2`) - Test execution

## Features

- **DataProcessor** class that demonstrates JSON processing and logging
- **StringUtils** class that provides enhanced string utilities using Apache Commons Lang
- Comprehensive unit tests using JUnit 5
- Uses property variables for version management
- Clean Maven project structure

## Building

```bash
mvn clean compile test package
```

## Running

```bash
# Run DataProcessor
java -cp target/classes com.example.DataProcessor

# Run StringUtils demonstration
java -cp target/classes com.example.StringUtils
```

## Testing

```bash
mvn test
```

This project is perfect for testing dependency analyzers because:

1. **Limited Dependencies**: Only 4 main dependencies to analyze
2. **Transitive Dependencies**: Each dependency brings in its own dependencies  
3. **Property Usage**: Uses Maven properties for version management
4. **Different Scopes**: Includes test-scoped dependencies
5. **Real Functionality**: Actually compiles and runs successfully

## Expected Analysis Results

Your dependency analyzer should find:

### Direct Dependencies
- `com.fasterxml.jackson.core:jackson-databind:2.15.2`
- `org.apache.commons:commons-lang3:3.12.0`
- `org.slf4j:slf4j-api:2.0.7` 
- `ch.qos.logback:logback-classic:1.4.11`
- `org.junit.jupiter:junit-jupiter:5.10.0` (test scope)

### Transitive Dependencies
Jackson and Logback will pull in additional transitive dependencies that should be discovered during Maven dependency resolution.

### Build Plugins
- `org.apache.maven.plugins:maven-compiler-plugin:3.11.0`
- `org.apache.maven.plugins:maven-surefire-plugin:3.1.2`
