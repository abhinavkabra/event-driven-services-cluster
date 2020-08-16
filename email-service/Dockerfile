#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine
MAINTAINER Abhinav Kabra <abhinavkabra411@gmail.com>

VOLUME /tmp

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.email.EmailApplication"]