# Crone is a Spring MVC web application for parsing cron expressions. 

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

The endpoint for accesing application is /input where a cron expression can be entered with a following command. 
![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/3502600c-5024-403f-bb08-80aada1d93d3)
Note that only valid cron expression will be parsed. If the entered expression is not a valid cron expression then a following message will apper: 
![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/6bb6d2f2-b821-4b7b-ba6c-93e39af34eff)
Once Submit button is pressed, redirection to /print view is executed and parsing result is presented in a following table:
![image](https://github.com/vladislavpn/crone_parser_web/assets/123036820/0832e35d-f0e2-43e0-98a8-9161ecfe9be1)


