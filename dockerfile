FROM openjdk:17
EXPOSE 8090
ADD ./target/DevOps_Project.jar DevOps_Project.jar
ENTRYPOINT ["java","-jar","DevOps_Project.jar"]
