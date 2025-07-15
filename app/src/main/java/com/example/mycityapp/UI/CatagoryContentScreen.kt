package com.example.mycityapp.UI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.data.dataSource
import com.example.mycityapp.R
@Composable
fun catagoryContentScreen(catagoryName : String, onClick : () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()) {
        // For example, you can use Text or any other composable to show category name
            Text(text = catagoryName) // Assuming category has a 'name' property

            // Call CategoryItem to display items in the selected category
            CategoryItem(catagoryName, onClick)

    }
}

@Composable
fun CategoryItem(catagoryName : String, onClick : () -> Unit) {
    val items = dataSource.categories
    LazyColumn(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .clickable(onClick = onClick)
    ) {
        items(items) { item ->
            // Display each item in the category
            // For example, you can use Text or any other composable to show item details
            Text(text = item.name,
                modifier = Modifier) // Assuming item has a 'name' property
        }
    }
}

@Preview
@Composable
fun PreviewCategoryContentScreen() {
    catagoryContentScreen(
        catagoryName = "Cuisine",
        onClick = {})
}