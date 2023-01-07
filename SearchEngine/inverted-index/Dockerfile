FROM openjdk:11
COPY target/inverted-index-1.0-SNAPSHOT-jar-with-dependencies.jar /home/search-engine/inverted-index/
WORKDIR /home/search-engine/inverted-index
CMD ["java", "-jar", "inverted-index-1.0-SNAPSHOT-jar-with-dependencies.jar"]