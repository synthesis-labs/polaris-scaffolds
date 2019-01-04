package [[ .Component ]]

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

data class [[ .Component ]](val content: String)

@RestController
class ComponentController {

    val counter = AtomicLong()

    @GetMapping("/[[ .Component ]]")
    fun getResource() =
            [[ .Component ]]("Hello from [[ .Component ]] service (GET)")

    @GetMapping("/[[ .Component ]]s")
    fun getResourceList() =
            [[ .Component ]]("Hello from [[ .Component ]] service (GET list)")
}