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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.data.dataSource
import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.CitySpecials

@Composable
fun mainScreen(
    modifier: Modifier,
    onCategoryClick: (CityCategory) -> Unit,
) {
    val categories = dataSource.categories
    LazyVerticalGrid(
        GridCells.Adaptive(minSize = 144.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.padding_small))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                onCategoryClick = onCategoryClick
            )
        }
    }

}


@Composable
fun CategoryItem(
    category: CityCategory,
    onCategoryClick: (CityCategory) -> Unit,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(id = R.dimen.padding_small),
            horizontal = dimensionResource(id = R.dimen.padding_small))
        .clickable(onClick = {onCategoryClick(category)}),
    ) {
        Column {
            Image(
                painter = painterResource(id = category.imageResId ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
            )
            Text(
                text = category.name,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun CategoryContentScreen(
    categoryName: String,
    //category: CitySpecials,
    onCategoryClick: (CitySpecials) -> Unit,
) {
    // This function can be used to display the content of a specific category
    val items = dataSource.getCategoryDetails(categoryName)
    LazyVerticalGrid(
        GridCells.Adaptive(minSize = 144.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.padding_small))
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        items(items) { it ->
            CategoryDetail(
                it.title,
                it,
                onCategoryClick = {onCategoryClick(it)}
            )
        }
    }
}


@Composable
fun CategoryDetail(
    categoryName: String,
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

@Composable
fun detailscreen(categoryName: String, categoryDesc : String, imgRes : Int) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small))
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imgRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Text(
            text = categoryName,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = categoryDesc,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
        )
    }
}

@Preview
@Composable
fun mainScreenPreview() {
    mainScreen(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        onCategoryClick = {}
    )
}
@Preview
@Composable
fun ContentScreenPreview() {
    CategoryContentScreen("Cuisine",
        onCategoryClick = {}
    )
}

@Preview
@Composable
fun detailScreenPreview() {
    detailscreen("Cuisine",
        "A slow-cooked beef stew flavored with spices, traditionally eaten at breakfast.",
        R.drawable.nihari,
    )
}