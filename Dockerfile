FROM openjdk:11
ADD target/parsamosir-api-0.0.1-SNAPSHOT.jar parsamosir-api-0.0.1-SNAPSHOT.jar
EXPOSE 1992
ENTRYPOINT [ "java", "-jar", "parsamosir-api-0.0.1-SNAPSHOT.jar"]