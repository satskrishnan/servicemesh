FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/servicemesh.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

RUN echo "Asia/Kolkata" > /etc/timezone

# java -jar /opt/app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=Asia/Kolkata", "-jar", "app.jar"]
