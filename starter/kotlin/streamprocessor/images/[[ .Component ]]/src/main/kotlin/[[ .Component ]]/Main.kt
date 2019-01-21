package [[ .Component ]]

import polaris.kafka.PolarisKafka
import org.apache.kafka.streams.KeyValue

import [[ .Component ]].schema.InputType
import [[ .Component ]].schema.OutputType

fun main(args : Array<String>) {

    val kafkaClientName = "[[ .Component ]]-client"

    with(PolarisKafka(kafkaClientName)) {

        // Input topic containing records of type InputType
        //
        val inputTopic = topic<String, InputType>(
            "[[ .Component ]]-input",
            12,
            1)

        // Output topic containing records of type OutputType
        //
        val outputTopic = topic<String, OutputType>(
            "[[ .Component ]]-output",
            12,
            1)

        // Map the firstname & surname from the input stream to the fullname in 
        // the output stream
        //
        consumeStream(inputTopic)
            .map { key, value ->
                KeyValue(key, OutputType(
                    value.getFirstname() + " " + value.getSurname())
                )
            }
            .to(outputTopic.topic, outputTopic.producedWith())

        // Start this stream processor
        //
        start()
    }

}