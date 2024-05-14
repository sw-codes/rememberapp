package com.swright.rememberapptakethree.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swright.rememberapptakethree.R
import com.swright.rememberapptakethree.room.models.ThingToRemember
import com.swright.rememberapptakethree.viewmodels.RememberViewModel

@Composable
fun RememberListScreen(
    modifier: Modifier = Modifier,
    screenTitle: String? = "Remember App",
) {
    val viewModel = viewModel<RememberViewModel>(
        factory = object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RememberViewModel(
                    screenTitle = "$screenTitle"
                ) as T
            }
        }
    )
//    viewModel.getThingsToRememberByCategory("$screenTitle")
    val thingsToRememberList by viewModel.rememberList.observeAsState()
//    thingsToRememberList = viewModel.getThingsToRememberByCategory("$screenTitle")

    var inputText by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            RememberAppBar(title = screenTitle)
        },
        content = {paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .padding(paddingValues)
                    .padding(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = inputText,
                        onValueChange = {
                            inputText = it
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        viewModel.addThingToRemember(title = inputText, category = "$screenTitle")
                    }) {
                        Text(text = "Save")
                    }
                }
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .padding(horizontal = 16.dp)
                )
                thingsToRememberList?.let {
                    LazyColumn(
                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp),
                        content = {
                            itemsIndexed(it) {index: Int, item: ThingToRemember ->
                                ThingToRememberListItem(
                                    thingToRemember = item,
                                    onDelete = {
                                        viewModel.deleteThingToRemember(item.id)
                                    })
                            }
                        }
                    )
                }?: Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    text = "No items added yet.",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    )


}

@Composable
fun ThingToRememberListItem(
    modifier: Modifier = Modifier,
    thingToRemember: ThingToRemember,
    onDelete: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = thingToRemember.title,
                fontSize = 24.sp
            )
            IconButton(onClick =  onDelete) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete"
                )
            }
        }
    }

}