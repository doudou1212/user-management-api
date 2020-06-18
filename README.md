## start server

### without docker

start database:

```bash
docker-compose up postgres_base
```

start java server:

```bash
export DB_HOST=0.0.0.0
export DB_PORT=5434
export DB_NAME=user
export DB_USER=usermanagement
export DB_PASSWORD=password10

./gradlew bootRun
```

The server is in `localhost:8080`

### with docker

start server:

```bash
docker-compose up dev
```

The server is in `localhost:80802`
