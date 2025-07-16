package com.example.mycityapp.UI

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.CitySpecials
import kotlinx.coroutines.flow.MutableStateFlow

class CityViewModel : ViewModel() {
    private val _cityViewModelState = MutableStateFlow( CityViewModelState())
    val cityViewModelState = _cityViewModelState

    fun getCategories(): List<CityCategory> {
        cityViewModelState.value = cityViewModelState.value.copy(
            getCategory = DataSource.categories
        )
        return cityViewModelState.value.getCategory
    }
    fun getCategoriesDetail(categoryName: String): List<CitySpecials> {
        cityViewModelState.value = cityViewModelState.value.copy(
            getCategoriesDetail = DataSource.getCategoryDetails(categoryName)
        )
        return cityViewModelState.value.getCategoriesDetail
    }


}

data class CityViewModelState(
    val getCategory: List<CityCategory> = emptyList(),
    val getCategoriesDetail : List<CitySpecials> = emptyList()
)