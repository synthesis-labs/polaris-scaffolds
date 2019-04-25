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