package com.example.mycityapp.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.model.CitySpecials

@Composable
fun CategoryContentScreen(
    categoryName: String,
    viewModel: CityViewModel,
    onCategoryClick: (CitySpecials) -> Unit,
) {
    // This function can be used to display the content of a specific category
    val items = viewModel.getCategoriesDetail(categoryName)
    LazyVerticalGrid(
        GridCells.Adaptive(minSize = 144.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.padding_small))
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        items(items) { it ->
            CategoryDetail(
                it,
                onCategoryClick = {onCategoryClick(it)}
            )
        }
    }
}


@Composable
fun CategoryDetail(
    item : CitySpecials,
    onCategoryClick: (CitySpecials) -> Unit,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(id = R.dimen.padding_small))
        .clickable(onClick = {onCategoryClick(item)} ),
    ) {
        Column {
            Image(
                painter = painterResource(id = item.imageResId ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
            )
            Text(
                text = item.title,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview
@Composable
fun ContentScreenPreview() {
    CategoryContentScreen("Cuisine",
        viewModel = viewModel(),
        onCategoryClick = {}
    )
}