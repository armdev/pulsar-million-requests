#!/usr/bin/env bash
set -e

echo "Down old Docker containers"
docker-compose down
echo "Start all containers"
docker-compose  up -d --build








