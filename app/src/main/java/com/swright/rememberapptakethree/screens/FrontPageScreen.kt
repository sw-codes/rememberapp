package com.swright.rememberapptakethree.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
//                items(LocalDataSource.mainMenuList) { item ->
//                    FrontPageMenuItem(
//                        menuItem = item,
//                        onItemClicked = onItemClicked
//                    )
//                }
                itemsIndexed(LocalDataSource.mainMenuList) {index, item ->
                    FrontPageMenuItem(
                        menuItem = item,
                        menuImage = LocalDataSource.mainMenuPhotoList[index],
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
    menuImage: Int,
    onItemClicked: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                onItemClicked(menuItem)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.height(220.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = menuImage),
                contentDescription = menuItem
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                text = menuItem,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RememberAppBar(
    title: String?
) {
    TopAppBar(title = {
        Text(
            text = "$title",
            style = MaterialTheme.typography.titleLarge
        )
    })
}