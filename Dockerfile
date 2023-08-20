FROM openjdk:20
COPY target/flight-api.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]