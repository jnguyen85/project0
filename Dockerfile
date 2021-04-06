FROM openjdk:12-jdk-alpine

WORKDIR /usr/app

COPY app/build/libs/app.jar ./

CMD ["java", "-jar", "app.jar"]