#!/usr/bin/env bash
mvn clean
docker rm -f $(docker ps -a -q)
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
echo "clean all targets"
find . -type d -name target -prune -exec rm -r {} +

docker images


