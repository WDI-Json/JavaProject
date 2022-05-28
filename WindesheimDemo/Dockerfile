FROM openjdk:17.0.2
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# FROM maven:3.8.3-openjdk-17
# COPY . /build/
# RUN rm -rf /build/src/test && cd build && mvn package && cp /build/target/*.jar /app.jar
# ENV _JAVA_OPTIONS="-Dlogging.level.org.springframework=INFO"
# ENTRYPOINT ["java","-jar","/app.jar"]
