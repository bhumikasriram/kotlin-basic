package com.thoughtworks.kotlin.apis

import com.thoughtworks.kotlin.models.Product
import com.thoughtworks.kotlin.models.Inventory
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("inventories")
    suspend fun getInventories(): List<Inventory>
}
