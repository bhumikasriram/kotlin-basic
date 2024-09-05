package com.thoughtworks.kotlin

import com.thoughtworks.kotlin.service.displayProducts
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    displayProducts()  // Calls the function to display products in the console
}
