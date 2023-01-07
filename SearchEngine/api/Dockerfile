FROM openjdk:11
COPY target/api-1.0-SNAPSHOT-jar-with-dependencies.jar /home/search-engine/api/
WORKDIR /home/search-engine/api
EXPOSE 4567
CMD ["java", "-jar", "api-1.0-SNAPSHOT-jar-with-dependencies.jar"]




