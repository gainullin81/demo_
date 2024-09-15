# Stage 1: Build React app
FROM node:16-alpine as build

WORKDIR /app

COPY frontend/package.json frontend/package-lock.json ./
RUN npm install

COPY frontend/ ./
RUN npm run build

# Stage 2: Build Spring Boot app
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build ./src/main/resources/static

COPY . .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
