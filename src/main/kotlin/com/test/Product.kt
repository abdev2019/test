package com.test

data class Product(
    val id: String,
    val name: String
)

data class ProductsResponse(
        val products: List<Product>
)