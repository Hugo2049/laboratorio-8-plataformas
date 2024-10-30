package com.uvg.lab8plats.pantallas.repository

import com.uvg.lab8plats.networking.webservices.MealsWebService
import com.uvg.lab8plats.networking.response.meals.Meal

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun filterByCategory(category: String): List<Meal> {
        return webService.filterMealsByCategory(category).meals
    }
}