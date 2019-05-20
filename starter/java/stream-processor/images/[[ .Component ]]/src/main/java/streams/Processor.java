package streams;

import [[ .Component ]].schema.*;
import polaris.kafka.PolarisKafka;
import polaris.kafka.SafeTopic;

public class Processor {
    public static void main(String[] args) {

        PolarisKafka app = new PolarisKafka("[[ .Component ]]-application");
        SafeTopic<[[ .Component ]]Key, [[ .Component ]]Value> exampleTopic = app.topic("[[ .Component ]]-topic", 12, 2, true);

        app.consumeStream(exampleTopic)
            .peek((key, value) -> { System.out.println("$key -> $value"); });

        app.start(null);
    }
}