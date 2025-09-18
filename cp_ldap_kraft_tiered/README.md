# KRaft + Tiered Storage (local MinIO)

Confluent's tiered storage demo with local MinIO installation. Does use RBAC and is set up in KRaft mode.


## Access
- MinIO avaialable `http://localhost:9001/ (admin:dmin_pass)` 
- openbLdap `http://localhost:8010 (cn=admin,dc=mimacomdemo,dc=com :admin)` 
- CC `http://localhost:9021`

## Commands

- create sample topic
```bash
kafka-topics \
    --bootstrap-server localhost:9092 \
    --create \
    --topic test-topic \
    --partitions 1 \
    --command-config /tmp/client.properties
```
- produce with perf-test
```bash
kafka-producer-perf-test --topic test-topic \
    --producer.config /tmp/client.properties \
    --num-records 5000000 \
    --print-metrics \
    --record-size 5000 \
    --throughput -1 \
    --producer-props acks=all bootstrap.servers=localhost:9092 batch.size=8196
```
- and consume
```bash
kafka-console-consumer  \
--topic test-topic \
--consumer.config /tmp/client.properties  \
--bootstrap-server localhost:9092 \
--from-beginning 
        
```
    
