package com.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Component
@Service
class Importer(
    @Autowired private val testRepository: TestRepository,
    @Autowired private val restTemplate: RestTemplate
) {

    @Scheduled(cron = "*/20 * * * * *") // every 20 seconds execute importVideos()
    fun importVideos(){
        println("Sending new request...")
        val response = restTemplate.exchange(
            "https://store7.gofile.io/download/VgsHAj/300be08d2145fbc3ea3eaa4b2a26cc49/products.json",
            HttpMethod.GET,
            null,
                ProductsResponse::class.java
        )

        println("Getting new response: $response")

        response.body?.products?.forEach { product->
            println("Saving product: $product")
            testRepository.saveProduct(product)
        }
    }

}
