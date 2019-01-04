package [[ .Component ]]

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    while(true) {
        println("Streamprocessor [[ .Component ]] running")
        Thread.sleep(1_000)
    }
}