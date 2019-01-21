FROM gradle:4.2.1-jdk8-alpine as build

ADD --chown=gradle build.gradle settings.gradle /home/gradle/project/
ADD --chown=gradle src /home/gradle/project/src/
RUN cd /home/gradle/project/ && gradle clean installDist

FROM openjdk:10-jre

WORKDIR app
COPY --from=build /home/gradle/project/build/install/[[ .Component ]] .

VOLUME /tmp

CMD ["bin/[[ .Component ]]"]