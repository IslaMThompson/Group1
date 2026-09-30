FROM amazoncorretto:17
COPY ./target/group1App.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group1App.jar"]