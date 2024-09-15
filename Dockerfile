FROM eclipse-temurin:17-jdk-alpine
LABEL authors="raphael.costa/Mariana.Sukevicz"

VOLUME /tmp
EXPOSE 8081

ADD target/oauth-ms-0.0.1-SNAPSHOT.jar OauthService.jar
ENTRYPOINT ["java","-jar","/OauthService.jar"]