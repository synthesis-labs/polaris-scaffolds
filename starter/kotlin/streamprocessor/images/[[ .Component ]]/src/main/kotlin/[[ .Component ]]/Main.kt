package [[ .Component ]]

import [[ .Component ]].schema.Region
import [[ .Component ]].schema.[[ .Component ]]Key
import de.huxhorn.sulky.ulid.ULID
import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema
import org.apache.kafka.streams.KeyValue
import polaris.kafka.PolarisKafka

fun main(args : Array<String>) {

    with(PolarisKafka("[[ .Component ]]-application")) {

        /*
         * Below is an example to get you started, replace with your stream processors
         */

        // Input topic containing records of type KsqlDataSourceSchema
        // This is an example schema from confluent
        //
        val userTopic = topicStringKey<String, KsqlDataSourceSchema>(
            "[[ .Component ]]-users",
            12,
            1)

        // Output topic containing records of type Region
        //
        val femaleRegionTopic = topic<[[ .Component ]]Key, Region>(
            "[[ .Component ]]-female-regions",
            12,
            1)

        // Filter the user input stream for only females
        // Map to an output stream with female regions
        //
        consumeStream(userTopic)
            .filter { _, user -> user.getGender() == "FEMALE" }
            .map { _, user ->
                val ulid = ULID().nextULID().capitalize()
                println("Found female in region ${user.getRegionid()}")
                KeyValue([[ .Component ]]Key(ulid), Region(user.getRegionid()))
            }
            .to(femaleRegionTopic.topic, femaleRegionTopic.producedWith())


        // Start this stream processor
        //
        start()
    }
}