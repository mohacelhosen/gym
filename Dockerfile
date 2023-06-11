FROM openjdk:17
COPY target/gym-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java","-jar", "gym-0.0.1-SNAPSHOT.jar"]