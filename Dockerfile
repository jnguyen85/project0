FROM openjdk:12-jdk-alpine

COPY app/build/libs/app.jar /app.jar

CMD ["java", "-jar", "app.jar"]