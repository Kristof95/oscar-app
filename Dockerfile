FROM alpine:latest
VOLUME /tmp
ADD target/driver.oscar.war driver.oscar.jar
RUN sh -c 'touch /driver.oscar.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/driver.oscar.jar"]