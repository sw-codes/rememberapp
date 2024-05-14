package com.swright.rememberapptakethree.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swright.rememberapptakethree.data.LocalDataSource

@Composable
fun SubMenuScreen(
    modifier: Modifier = Modifier,
    screenTitle: String? = "Remember App",
    onSubMenuItemClicked: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            RememberAppBar(title = screenTitle)
        },
        content = { paddingValues ->
            when (screenTitle) {
                "Eat" -> {
                    LazyVerticalGrid(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(4.dp),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(LocalDataSource.eatList) { item ->
                            SubMenuPageItem(
                                item = item,
                                onSubMenuItemClicked = onSubMenuItemClicked
                            )
                        }
                    }
                }

                "Exercise" -> {
                    LazyVerticalGrid(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(4.dp),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(LocalDataSource.exerciseList) { item ->
                            SubMenuPageItem(
                                item = item,
                                onSubMenuItemClicked = onSubMenuItemClicked
                            )
                        }
                    }
                }

                "Relax" -> {
                    LazyVerticalGrid(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(4.dp),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(LocalDataSource.relaxList) { item ->
                            SubMenuPageItem(
                                item = item,
                                onSubMenuItemClicked = onSubMenuItemClicked
                            )
                        }
                    }
                }
            }
        }
    )

}

@Composable
fun SubMenuPageItem(
    modifier: Modifier = Modifier,
    item: String,
    onSubMenuItemClicked: (String) -> Unit
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable {
                onSubMenuItemClicked(item)
            }
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = item,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}