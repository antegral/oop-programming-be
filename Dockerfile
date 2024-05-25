FROM docker.io/maven:3.9.6-amazoncorretto-17 as MAVEN_BUILD

WORKDIR /build

COPY pom.xml .

COPY src ./src

RUN mvn package -Dmaven.test.skip=true

FROM docker.io/amazoncorretto:17-alpine3.19

WORKDIR /app

ARG JAR_FILE=*.jar

COPY --from=MAVEN_BUILD /build/target/${JAR_FILE} ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
