FROM openjdk:8-jdk-alpine
MAINTAINER svgagan

ADD build/libs/*.jar justice-league.jar

ENTRYPOINT java -jar justice-league.jar