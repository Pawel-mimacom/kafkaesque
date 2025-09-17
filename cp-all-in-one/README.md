1. docker-compose exec -it broker /bin/bash

2. kafka-topics.sh \
    --bootstrap-server localhost:9092 \
    --create \
    --topic test-topic \
    --partitions 10 

3. intellij:  sb-kafka-share-consumer

4. /opt/kafka/bin/kafka-producer-perf-test.sh --topic test-topic \
    --num-records 5000 \
    --print-metrics \
    --record-size 50 \
    --throughput 5 \
    --producer-props acks=all bootstrap.servers=localhost:9092 batch.size=1


https://github.com/khiemdoan/kafka-kraft-cluster-docker-compose/blob/main/README.md 

/opt/kafka/bin/kafka-features.sh --bootstrap-server localhost:9092 upgrade --feature share.version=1

spring.kafka.properties.share.acknowledgement.mode: explicit
in grafana (http://localhost:3000) define prometheus source connection (http://prometheus:9090)


