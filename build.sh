#!/usr/bin/env bash

set -e

echo "Build the system"
mvn clean package -U -Dmaven.test.skip=true
#mvn clean install -pl pulsar -am -DskipTests=true




