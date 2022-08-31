FROM maven:3.8-openjdk-18@sha256:991f06415ecdb46ff5fc94ab73265a4b915be8cc2076a05c8a8991b078bbec28 as build

COPY . /src

WORKDIR /src

RUN mvn clean package spring-boot:repackage

FROM openjdk:18-oracle@sha256:833d7ab8fa3295871319af79d0ec76c590d61125c903438c0e5f3526db842569

COPY --from=build /src/target/customer-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD "java" "-jar" "customer-0.0.1-SNAPSHOT.jar"
