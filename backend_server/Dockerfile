FROM eclipse-temurin:19-jdk-focal
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./
COPY src ./src
RUN ./mvnw package
EXPOSE 8080
CMD ["java", "-jar", "target/PracticeProject-0.0.1-SNAPSHOT.jar"]
# CMD ["./mvnw", "spring-boot:run"]
