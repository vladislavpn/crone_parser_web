# A Spring MVC web application for parsing crone expressions. 

## Structure
```
├── main
│   ├── java          
│   │   ├── com.vladpiven.cronewebapp    // Common response functions
│   │   │    ├── aspect                  // Logging with a use of Spring AOP framework 
│   │   │    ├── controller              // Controller class for managing web requests 
│   │   │    ├── service                 // Service layer
│   │   │    ├── util                    // Contains CroneHandler class repsponsible for parsing the expression                       
│   │   └── CroneParserWebApplication    // The entry point
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   │    ├── input.html            // HTML page responsible for input of crone expression
│   │   │    ├── print.html            // HTML page responsible for printing parsed crone expression
│   └── application.properties         // Configuration
```

The endpoint for accesing application is /input where a crone expression can be entered with a following command. 
Note that only valid crone expression will be parsed.

