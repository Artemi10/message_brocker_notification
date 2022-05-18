FROM openjdk:17-alpine
EXPOSE 8080
ADD target/consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/consumer-0.0.1-SNAPSHOT.jar"]
