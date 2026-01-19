# Utilisation d'une image de base légère
FROM eclipse-temurin:17-jdk-alpine

# Ajout d'un utilisateur non-root pour la sécurité (Best Practice)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/devsecops-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
