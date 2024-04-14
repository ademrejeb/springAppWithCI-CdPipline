FROM openjdk:17
EXPOSE 8090
ADD ./target/4TWIN1-G2-ProjetFinal-1.0.jar 4TWIN1-G2-ProjetFinal-1.0.jar
ENTRYPOINT ["java","-jar","4TWIN1-G2-ProjetFinal-1.0-SNAPSHOT.jar"]