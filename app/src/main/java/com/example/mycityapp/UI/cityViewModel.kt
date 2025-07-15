package com.example.mycityapp.UI

import androidx.lifecycle.ViewModel
import com.example.mycityapp.model.CityCategory
import kotlinx.coroutines.flow.MutableStateFlow

class cityViewModel : ViewModel() {
    private val _cityViewModelState = MutableStateFlow( CityViewModelState())
    val cityViewModelState = _cityViewModelState

    fun getSelectedCategory(): List<CityCategory> {
        return _cityViewModelState.value.selectedCategory
    }


}

data class CityViewModelState(
    val selectedCategory: List<CityCategory> = emptyList(),

    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    fun isCategorySelected() = selectedCategory != null

}