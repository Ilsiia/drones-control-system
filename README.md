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

## REST API
#### Authorization
User/Password
### Registering a drone
http://localhost:18080/drones/register
#### JSON example
{"serialNumber":"kjsh_oiui0003",
"model": "Lightweight",
"weightLimit": "50"}
### Loading a drone with medication items
http://localhost:18080/drones/load
### Checking loaded medication items for a given drone
http://localhost:18080/drones/medication?droneSerialNum=kjsh_oiui0003
### Checking available drones for loading
http://localhost:18080/drones/available
### Check drone battery level for a given drone
http://localhost:18080/drones/battery?droneSerialNum=kjsh_oiui0003
