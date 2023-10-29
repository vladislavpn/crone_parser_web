# Crone is a Spring MVC web application for parsing cron expressions. 

Crone is a simple Java Spring MVC web application that allows you to parse and visualize cron expressions. It provides two main endpoints: one for inputting a cron expression and another for displaying the parsed result in a user-friendly table format.

## Structure
```
├── main
│   ├── java          
│   │   ├── com.vladpiven.cronewebapp    // Common response functions
│   │   │    ├── aspect                  // Logging with a use of Spring AOP framework 
│   │   │    ├── controller              // Controller class for managing web requests 
│   │   │    ├── service                 // Service layer
│   │   │    ├── util                    // Contains CronHandler class repsponsible for parsing the expression                       
│   │   └── CronParserWebApplication    // The entry point
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   │    ├── input.html            // HTML page responsible for input of crone expression
│   │   │    ├── print.html            // HTML page responsible for printing parsed crone expression
│   └── application.properties         // Configuration
```

# Getting Started
Before you begin, ensure you have met the following requirements:
* Java Development Kit (JDK) installed on your system.
* Apache Maven for building the project.
* A web container (e.g., Apache Tomcat) to deploy the application.

Clone the Repository

# Build and run
1. Build the project using Maven: mvn clean package
2. Deploy the generated WAR file (e.g., crone.war) to your web container.
3. Access the application at http://localhost:8080/input

# Using the Application
Crone provides two simple endpoints for parsing cron expressions:

1. Input Cron Expression: Visit /input to input a cron expression.
2. Parsed Cron Result: Visit /print to see the parsed cron expression displayed in a table with rows for each cron field (e.g., seconds, minutes, etc.).

# Example
Input Cron Expression: Enter a cron expression (e.g., */15 0 1,15 * 1-5) and submit.

![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/3502600c-5024-403f-bb08-80aada1d93d3)

Note that only valid cron expression will be parsed. If the entered expression is not a valid cron expression then a following message will apper: 

![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/6bb6d2f2-b821-4b7b-ba6c-93e39af34eff)

Parsed Cron Result: The application will display a table with fields like second, minute, hour, day of the month, month, and day of the week, showing the values for each field based on the provided cron expression.

![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/0832e35d-f0e2-43e0-98a8-9161ecfe9be1)






