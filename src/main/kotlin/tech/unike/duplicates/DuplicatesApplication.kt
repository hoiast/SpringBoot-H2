package tech.unike.duplicates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DuplicatesApplication

fun main(args: Array<String>) {
	runApplication<DuplicatesApplication>(*args)
}
