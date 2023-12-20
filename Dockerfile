FROM openjdk:17-oracle
RUN mkdir /app
COPY target/docker2023-0.0.1-SNAPSHOT.jar /app
ENV TZ=America/Bogota
CMD ["java", "-jar", "/app/docker2023-0.0.1-SNAPSHOT.jar"]
