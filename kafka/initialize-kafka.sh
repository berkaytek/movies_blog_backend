docker exec -it kafka bash
kafka-topics --create --topic user-created --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
