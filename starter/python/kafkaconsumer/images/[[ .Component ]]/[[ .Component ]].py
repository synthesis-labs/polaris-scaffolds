import time, os, json, random
import kafka

# Grab environment variables
#
brokers = os.environ.get("kafka_bootstrap_servers", "127.0.0.1:9092")
topic = os.environ.get("topic", "topic_1")

print ("brokers=%s"%(brokers))
print ("topic=%s"%(topic))

if __name__ == "__main__":
	client_id = "[[ .Component ]]"
	group_id = "[[ .Component ]]"
	consumer = kafka.KafkaConsumer(bootstrap_servers=brokers, client_id=client_id, group_id=group_id)
	consumer.subscribe(topics=[topic])

	for message in consumer:
		# Receive a message from the topic
		value = message.value
		print("Consumed: %s"%value)

	consumer.close()

