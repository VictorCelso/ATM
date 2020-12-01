FROM openjdk:12-alpine
VOLUME /tmp
ENV SPRING_PROFILES_ACTIVE=prod
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","test.atl.atm"]
