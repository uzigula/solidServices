FROM gcr.io/distroless/java
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /usr/app/app.jar
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]
#ENTRYPOINT exec java -XX:+UseParallelGC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1  -XX:NewRatio=2  -Djava.security.egd=file:/dev/./urandom -jar /app.jar