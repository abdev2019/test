package com.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController(
    private val testRepository: TestRepository
){
    @GetMapping("/test")
    fun getProducts(): MutableList<Product> {
        return testRepository.getProducts()
    }
}
