FROM openjdk:8-alpine
CMD java ${JAVA_OPTS} -Dspring.profiles.active=prod -jar soufun.jar
HEALTHCHECK --start-period=60s --interval=5s --retries=12 --timeout=5s CMD curl -f http://localhost:8130/actuator/health || exit 1
COPY target/soufun-0.0.1-SNAPSHOT.jar ./soufun.jar
