FROM --platform=linux/amd64 openjdk:17-oracle
EXPOSE 8081
ADD build/libs/gateway-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar" ]