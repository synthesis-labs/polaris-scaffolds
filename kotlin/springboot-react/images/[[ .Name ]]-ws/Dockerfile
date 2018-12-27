FROM gradle:5.0.0-jdk8-alpine as build
ADD --chown=gradle . /home/gradle/project/
RUN cd /home/gradle/project/ && gradle build

FROM openjdk:10-jre
WORKDIR app
COPY --from=build /home/gradle/project/build/ .
VOLUME /tmp

CMD ["java", "-jar", "libs/[[ .Name ]]-ws.jar"]