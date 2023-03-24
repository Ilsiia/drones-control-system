### Building:

Run maven command:

```bash
./mvnw clean package
```

### Running

After building jar, copy target/dcs-0.0.1-SNAPSHOT.jar to src/main/docker

for Linux:

```bash
cp target/dcs-0.0.1-SNAPSHOT.jar src/main/docker
```

Then we should up docker:

```bash
docker-compose up
```

press Ctrl + C for escaping then, for stopping all services:

```bash
docker-compose down
```