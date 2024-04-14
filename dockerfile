FROM openjdk:17

WORKDIR /app

COPY ./target/4TWIN1-G2-ProjetFinal-1.0.jar /app/4TWIN1-G2-ProjetFinal-1.0.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/4TWIN1-G2-ProjetFinal-1.0.jar"]
