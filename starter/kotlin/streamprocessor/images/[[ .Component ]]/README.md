# Polaris Stream Processor

1. Open this folder in IntelliJ and run a build. The build generates AVRO schemas for all `avsc` files
2. Right click the directory `build/main-generated-avro-java` and mark as generated source directory
3. To run, add an application configuration, set `Use classpath of module` and `Main class` to the main class
4. Code up your stream processor in `Main.kt`!

---

### Optional - Confluent cloud

Polaris Kafka is setup to use confluent cloud, simply provide the following environment variables:

```sh
# Example
kafka_bootstrap_servers=ppp-l9eee.eu-west-1.aws.confluent.cloud:9092
schema_registry_url=https://ppp-l9eee.us-east-2.aws.confluent.cloud
confluent_cloud_key=5AAAAAWUAAAAAM
confluent_cloud_secret=1cUxxkKkOFvYYY9Xx1iZ1Z4XbjeVxxUoIQa1UImmmmDxxXXX3xLjWmXx1xX
confluent_cloud_schema_key=5AAAAAWUAAAAAM
confluent_cloud_schema_secret=1cUxxkKkOFvYYY9Xx1iZ1Z4XbjeVxxUoIQa1UImmmmDxxXXX3xLjWmXx1xX 
```

---

### Optional - Test data (Linux / Mac)

Generate test data using a quickstart user schema from confluent platform

```sh
$ ksql-datagen quickstart=users topic=[[ .Component ]]-users format=avro maxInterval=10000
```

Consume topics using confluent console consumer

```sh
$ confluent consume [[ .Component ]]-users --value-format avro --from-beginning
$ confluent consume [[ .Component ]]-female-regions --value-format avro --from-beginning
```

This sample also has example schemas that can be used to generate test data

```sh
$ ksql-datagen schema=images/[[ .Component ]]/src/main/avro/example.user.schema.avsc format=avro topic=users key=userid iterations=100 maxInterval=100
$ ksql-datagen schema=images/[[ .Component ]]/src/main/avro/example.pageview.schema.avsc format=avro topic=pageviews key=userid
```