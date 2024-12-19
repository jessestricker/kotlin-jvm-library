package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LibraryTest {
    @Test
    fun `greeting returns well-known phrase`() {
        val library = Library()
        val greeting = library.greeting
        assertEquals("Hello, World!", greeting)
    }
}
