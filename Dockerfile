FROM openjdk:8-jre-alpine
ADD target/docker-spring-mysql.jar docker-spring-mysql.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar" , "docker-spring-mysql.jar"]