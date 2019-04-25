# Polaris Stream Processor

To open with intelliJ:

```sh
$ gradle build
$ gradle idea
```

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