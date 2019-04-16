FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ARG MY_ENV
COPY ${JAR_FILE} app.jar
ENV PROFILE ${MY_ENV}
ENTRYPOINT exec java -XX:+UseParallelGC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1  -XX:NewRatio=2 -Denv.MY_ENV=$PROFILE -Djava.security.egd=file:/dev/./urandom -jar /app.jar