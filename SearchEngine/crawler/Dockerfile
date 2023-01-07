FROM openjdk:11
COPY target/crawler-1.0-SNAPSHOT-jar-with-dependencies.jar /home/search-engine/crawler/
COPY target/classes/config.properties /home/search-engine/crawler/
WORKDIR /home/search-engine/crawler
CMD ["java", "-jar", "crawler-1.0-SNAPSHOT-jar-with-dependencies.jar"]