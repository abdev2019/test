package com.test

import org.springframework.stereotype.Component


@Component
class TestRepository {
    private val table = mutableListOf<Product>()

    fun saveProduct(product: Product){
        table.add(product)
        println(table)
    }

    fun getProducts(): MutableList<Product> {
        return table
    }
}