package com.example.mycityapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycityapp.UI.CategoryContentScreen
import com.example.mycityapp.UI.cityViewModel
import com.example.mycityapp.UI.detailscreen
import com.example.mycityapp.UI.mainScreen


enum class MyCityAppScreens{
    mainScreen,
    CategoryContentScreen,
    CategoryDetailScreen,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(

    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    categoryName: String
) {
    CenterAlignedTopAppBar(
        title = { Text(categoryName) },
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.inverseOnSurface),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
@Composable
fun MyCityApp(modifier: Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityAppScreens.entries.firstOrNull {
        backStackEntry?.destination?.route?.startsWith(it.name) == true
    } ?: MyCityAppScreens.mainScreen
//    val currentScreen = MyCityAppScreens.valueOf(
//        backStackEntry?.destination?.route ?: MyCityAppScreens.mainScreen.name
//    )
    val viewModel : cityViewModel = viewModel()
    Scaffold(
        topBar = {
            MyCityAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                categoryName = when (currentScreen) {
                    MyCityAppScreens.mainScreen -> stringResource(R.string.app_name)
                    MyCityAppScreens.CategoryContentScreen -> {
                        backStackEntry?.arguments?.getString("categoryName")?: stringResource(R.string.app_name)
                    }
                    MyCityAppScreens.CategoryDetailScreen -> {
                        backStackEntry?.arguments?.getString("categoryName") ?: stringResource(R.string.app_name)
                    }
                },
                modifier = modifier,
            )
        },
    ) { innerPadding ->
        val uiState by viewModel.cityViewModelState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyCityAppScreens.mainScreen.name,
            Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityAppScreens.mainScreen.name) {
                mainScreen(
                    modifier = Modifier,
                    onCategoryClick = {
                        navController.navigate(
                            MyCityAppScreens.CategoryContentScreen.name + "/${it.name}"
                        )
                    }
                )
            }
            composable(MyCityAppScreens.CategoryContentScreen.name + "/{categoryName}", arguments = listOf(
                navArgument("categoryName"){
                    type = NavType.StringType
                }
            ) ) { it ->
                val selectedCategory = it.arguments?.getString("categoryName")
                if (selectedCategory != null){

                    CategoryContentScreen (
                        selectedCategory,
                    onCategoryClick =
                    {
                        navController.navigate(
                            MyCityAppScreens.CategoryDetailScreen.name + "/${it.title}/${it.desc}/${it.imageResId}"
                        )

                    }
                    )
                }
                else{
                    Text(
                        text = "category_not_found",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                }
            composable(MyCityAppScreens.CategoryDetailScreen.name + "/{categoryName}/{categoryDesc}/{imgRes}", arguments = listOf(
                navArgument("categoryName"){
                    type = NavType.StringType
                },
                navArgument("categoryDesc"){
                    type = NavType.StringType
                },
                navArgument("imgRes"){
                    type = NavType.IntType
                }
            ) ) {
                val selectedCategory = it.arguments?.getString("categoryName") ?: ""
                val categoryDesc = it.arguments?.getString("categoryDesc") ?: ""
                val imgRes = it.arguments?.getInt("imgRes") ?: 0
                if (selectedCategory != null){

                    detailscreen (
                        selectedCategory,
                        categoryDesc,
                        imgRes
                    )
                }
                else{
                    Text(
                        text = "category_not_found",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}