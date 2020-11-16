FROM openjdk:8-jdk-alpine

MAINTAINER francisco.seguel@pad.cl

VOLUME /tmp
ARG JAR_FILE
COPY . /usr/src/lpws
WORKDIR /usr/src/lpws

ENTRYPOINT ["java","-jar","target/awto-log-0.0.1-SNAPSHOT-dist/awto-log-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080