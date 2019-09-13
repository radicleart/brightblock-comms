# Radicle Comms

Communication module for gaia hub administration. 

## Table of Contents

- [Purpose](#purpose)
- [Privacy](#privacy)
- [Schema](#schema)
- [Test Environment](#test-environment)
- [Production Environment](#production-environment)
- [Comms API](#comms-api)
- [Roadmap](#roadmap)

## Purpose

Provides secure, private and encrypted setup of blockstack user storage.


## Privacy



## Schema

The schema for messages is a json struct;


## Test Environment

To run locally for testing you'll need java run time and docker installed on your machine;

1. Start Mongodb

```
docker run --name brightblock_mongo -v /data/db:/data/db -p 27017:27017 -d mongo:latest --smallfiles --bind_ip_all
```

2. Run the comms micro-service

```
git clone git@github.com:radicleart/brightblock-comms.git
cd brightblock-comms
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8002,suspend=n -jar target/brightblock-comms-0.0.1-SNAPSHOT.jar
```

and connect using..

```
mongo mongodb://127.0.0.1:27017
```

## Production Environment

The mongodb instance and microservices are designed to run in production using 
docker compose. This then means they can be run together with the the 
brightblock-search microservice which provides a full text index search over your
decentraslised gaia data.

## Comms API

### Clear Index

> value = "/comms/clear/{blockstackId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }

Clears messages for the current user.

## Roadmap

Plans for future development include;

1. Implement oauth for accessing the api - follow gaia oauth implementation.
2. Host the application using infrastructure as a service (e.g. Heroku Searchify).


