package com.example.kotlindemo.library

import org.springframework.stereotype.Service
import jakarta.annotation.PostConstruct

// Annotation
@Target(AnnotationTarget.CLASS)
annotation class CustomAnnotation(val author: String)

// Enum class
enum class Status {
    ACTIVE, INACTIVE
}

// Interface
interface ProcessorInterface<T> {
    fun process(data: T)
}

// Sealed class
sealed class Response {
    data class Success(val message: String) : Response()
    data class Error(val error: String) : Response()
}

// Abstract class
abstract class AbstractProcessor {
    fun log(msg: String) = println("LOG: $msg")
}

// Data class
data class User(val name: String, val age: Int)

// Generic class
class Box<T>(val content: T)

// Object singleton
object Utility {
    fun sayHello() = println("Hello from Utility object")
}

// Class with SpringBoot & Kotlin entities
@CustomAnnotation("Anmol")
@Service
class LibraryModule : AbstractProcessor(), ProcessorInterface<String> {

    // Companion object
    companion object {
        init {
            println("Companion object initialized")
        }

        fun staticCall() = println("Static-like call")
    }

    // Init block
    init {
        println("LibraryModule initialized")
    }

    // Function (method)
    override fun process(data: String) {
        println("Processing: $data")
    }

    fun multiply(a: Int, b: Int): Int = a * b

    // Overloaded function
    fun multiply(a: Double, b: Double): Double = a * b

    // Generic method
    fun <T> echo(item: T): T {
        println("Echo: $item")
        return item
    }

    @PostConstruct
    fun setup() {
        println("PostConstruct called in LibraryModule")
    }
}
