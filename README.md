# Detective Comics API

## Run using Docker-Compose 

Step-1: Create the jar file.
```
./gradlew clean build
```

Step-2: Build docker images and run using docker-compose.
```
Build Image:        docker build -t justice-league .
Run Containers:     docker-compose up -d
Stop Containers:    docker-compose down
```

## Swagger
http://localhost:8081/detective-comics/swagger-ui.html