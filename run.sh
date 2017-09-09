#!/bin/bash
mvn package
java -jar target/todo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
