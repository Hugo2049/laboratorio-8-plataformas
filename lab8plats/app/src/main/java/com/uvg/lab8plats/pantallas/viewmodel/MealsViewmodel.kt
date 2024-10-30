package com.uvg.lab8plats.pantallas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.lab8plats.networking.response.meals.Meal
import com.uvg.lab8plats.ui.meals.repositories.MealsRepository
import kotlinx.coroutines.launch

class MealsViewModel (val repository: MealsRepository = MealsRepository()): ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals

    fun fetchByCategory(category: String) {
        viewModelScope.launch {
            try {
                val meals = repository.filterByCategory(category)
                _meals.value = meals
            } catch (e: Exception) {
                Log.e("MealsViewModel", e.message.toString());
            }
        }
    }
}