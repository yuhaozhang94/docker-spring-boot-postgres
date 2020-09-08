FROM openjdk:8
ADD target/xp-management-0.0.1-SNAPSHOT.jar xp-management-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "xp-management-0.0.1-SNAPSHOT.jar"]