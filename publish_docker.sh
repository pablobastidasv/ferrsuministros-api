./mvnw package -Dquarkus.package.type=fast-jar
docker build -f src/main/docker/Dockerfile.fast-jar -t pablobastidasv/ferrosuministros .
docker image push pablobastidasv/ferrosuministros:latest
