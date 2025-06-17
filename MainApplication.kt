package com.example.kotlindemo

import com.example.kotlindemo.library.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class MainApplication(private val library: LibraryModule) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("Kotlin Spring Boot App started")

        library.process("Kotlin Spring Input")
        println("Multiply Int: ${library.multiply(3, 4)}")
        println("Multiply Double: ${library.multiply(2.5, 3.5)}")

        // Generics
        val echoed = library.echo("Generic Echo Test")
        println("Echoed: $echoed")

        // Data class
        val user = User("Anmol", 24)
        println("User: $user")

        // Enum
        val status = Status.ACTIVE
        println("Status: $status")

        // Sealed class usage
        val response: Response = Response.Success("Loaded successfully")
        when (response) {
            is Response.Success -> println("Success: ${response.message}")
            is Response.Error -> println("Error: ${response.error}")
        }

        // Singleton object
        Utility.sayHello()

        // Companion object usage
        LibraryModule.staticCall()

        // Generic class
        val box = Box("Item inside box")
        println("Box content: ${box.content}")
    }
}

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
