package com.uvg.lab8plats.networking

import com.uvg.lab8plats.networking.response.categories.MealsCategoriesResponse
import com.uvg.lab8plats.networking.response.meals.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {

    @GET("categories.php")
    suspend fun getMealsCategories(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun filterByCategory(
        @Query("c") category: String
    ): MealsResponse
}