import time, os, json, random
from confluent_kafka.admin import AdminClient, NewTopic
from confluent_kafka import KafkaException

# Grab environment variables
#
brokers = os.environ.get("kafka_bootstrap_servers", "127.0.0.1:9092")

print ("brokers=%s"%(brokers))

if __name__ == "__main__":

	admin = AdminClient({'bootstrap.servers': brokers})

	# Create topics
	#
	print("Creating topic...")
	new_topics = [
		NewTopic("topic_1", num_partitions=3, replication_factor=1),
		NewTopic("topic_2", num_partitions=3, replication_factor=1),
	]

	# Create the topics
	#
	fs = admin.create_topics(new_topics)
	for topic, f in fs.items():
		try:
			f.result()
			print("Topic %s created"%(topic))
		except Exception as e:
			print("Failed to create topic - %s"%(e))
