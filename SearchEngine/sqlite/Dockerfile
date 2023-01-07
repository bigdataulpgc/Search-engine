FROM openjdk:11
COPY target/sqlite-1.0-SNAPSHOT-jar-with-dependencies.jar /home/search-engine/sqlite/
WORKDIR /home/search-engine/sqlite
CMD ["java", "-jar", "sqlite-1.0-SNAPSHOT-jar-with-dependencies.jar"]