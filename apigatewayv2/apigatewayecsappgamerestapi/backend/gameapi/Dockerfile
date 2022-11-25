FROM openjdk:17-alpine

RUN mkdir -p //app
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 3071

CMD ["./mvnw", "spring-boot:run"]