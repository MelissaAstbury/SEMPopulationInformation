FROM openjdk:latest
COPY ./target/SEMPopulationInformation.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMPopulationInformation.jar", "db:3306", "30060"]