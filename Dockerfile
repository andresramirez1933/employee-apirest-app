FROM openjdk:8

#Informatiopn around who maintains the image
MAINTAINER andres.com

#Add the application's jar to the container
COPY target/employee-api-rest-0.0.1-SNAPSHOT.jar employee-api-rest-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar", "employee-api-rest-0.0.1-SNAPSHOT.jar"]