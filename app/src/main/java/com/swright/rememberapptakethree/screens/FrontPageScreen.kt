package com.swright.rememberapptakethree.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swright.rememberapptakethree.data.LocalDataSource

@Composable
fun FrontPageScreen(
    modifier: Modifier = Modifier,
    onItemClicked: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            RememberAppBar(title = "Remember App")
        },
        content = { paddingValues ->
            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(4.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(LocalDataSource.mainMenuList) { item ->
                    FrontPageMenuItem(
                        menuItem = item,
                        onItemClicked = onItemClicked
                    )
                }
            }
        }
    )

}

@Composable
fun FrontPageMenuItem(
    modifier: Modifier = Modifier,
    menuItem: String,
    onItemClicked: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .clickable {
                onItemClicked(menuItem)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = menuItem,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RememberAppBar(
    modifier: Modifier = Modifier,
    title: String?
) {
    TopAppBar(title = { Text(text = "$title") })
}