package org.example

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LibraryTest {
    @Test
    fun `greeting returns well-known phrase`() {
        val library = Library()
        val greeting = library.greeting
        greeting shouldBe "Hello, World!"
    }
}
