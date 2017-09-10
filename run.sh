#!/bin/bash
mvn clean package
nohup java -jar target/todo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod 2>&1 > run.log &
