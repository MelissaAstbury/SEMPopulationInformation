FROM openjdk:latest
COPY ./target/SEMPopulationInformation-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMPopulationInformation-0.1.0.3-jar-with-dependencies.jar"]