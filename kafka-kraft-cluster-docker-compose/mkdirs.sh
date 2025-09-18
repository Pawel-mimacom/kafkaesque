#!/bin/sh
set -e

mkdir -p .data
sudo chown -P 1000:1000 .data

# Apicurio
sudo mkdir -p .data/apicurio_db
sudo chown -P 999:999 .data/apicurio_db

# Kafka
sudo mkdir -p .data/controller-1
sudo chown -R 1000:1000 .data/controller-1

sudo mkdir -p .data/controller-2
sudo chown -R 1000:1000 .data/controller-2

sudo mkdir -p .data/controller-3
sudo chown -R 1000:1000 .data/controller-3

sudo mkdir -p .data/broker-1
sudo chown -R 1000:1000 .data/broker-1

sudo mkdir -p .data/broker-2
sudo chown -R 1000:1000 .data/broker-2

sudo mkdir -p .data/broker-3
sudo chown -R 1000:1000 .data/broker-3

mkdir -p .data/broker-4
sudo chown -R 1000:1000 .data/broker-4
