# Brightblock Comms

Communication and messaging microservice for blockstack d-apps and their users. 

## Table of Contents

- [Purpose](#purpose)
- [Privacy](#privacy)
- [Schema](#schema)
- [Test Environment](#test-environment)
- [Production Environment](#production-environment)
- [Comms API](#comms-api)
- [Roadmap](#roadmap)

## Purpose

Provides secure, private and encrypted messaging between blockstack users.

Two modes of communication are provided to facilitate communication between users who are both online and
with users who may also be offline at the time messages are sent. The former uses push
notifications over websockets and the latter provides standard http pull for new
messages.

This component is intended to complement the radiks server initiative at Blockstack. 
The thought is that providing different styles and ways to acheive these goals maximises the 
pool of people who can enter and help with the development.

The intention is for d-app developers to share or run their own brightblock-comms and search
servers either by;
1. shared hosting model - add new d-app domain in configuration,
2. siloed hosting - pull and run with docker.

## Privacy

Messages are encrypted json blobs that can only be read by the user(s) they are intended for.
This is acheived by the sender encrypting the message client side with the recipients
public key. 

Sender and recipient blockstack ids are obfuscated by;

1. Sending them to the server SHA256 hashed,
2. Rehashing this hash on the server using a private seed.

## Schema

The schema for messages is a json struct;

```
{ 
	id: id, // mongodb generated id.
	recipient: recipient, // Twice SHA256 hashed blockstack id
	sender: sender, // Twice SHA256 hashed blockstack id
	message: message, // public key encrypted message
	type: type, // type of message - set by the d-app
	domain: domain // d-app domain
}
```

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


