# MicroService
POC for spring cloud using Netflix

# Refactor to use multiple Eureka Servers

To make the application more fault tolerant, we can run multiple Eureka servers. Ordinarily we would run copies on different racks / data centers, but to simulate this locally do the following:

Stop all of the running applications.

Edit your computer's /etc/hosts file (c:\WINDOWS\system32\drivers\etc\hosts on Windows). Add the following lines and save your work:

# START section for Microservices with Spring Course
127.0.0.1       eureka-primary
127.0.0.1       eureka-secondary
127.0.0.1       eureka-tertiary
# END section for Microservices with Spring Course
Within the server project, add application.yml with multiple profiles: primary, secondary, tertiary. The server.port value should be 8011, 8012, and 8013 respectively. The eureka.client.serviceUrl.defaultZone for each profile should point to the "eureka-*" URLs of the other two; for example the primary value should be: http://eureka-secondary:8012/eureka/,http://eureka-tertiary:8013/eureka/

Run the application 3 times, using -Dspring.profiles.active=primary (and secondary, and tertiary) to activate the relevant profile. The result should be 3 Eureka servers which communicate with each other.

In your GitHub project, modify the application.properties eureka.client.serviceUrl.defaultZone to include the URIs of all three Eureka servers (comma-separated, no spaces).
