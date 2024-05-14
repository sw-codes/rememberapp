package com.swright.rememberapptakethree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swright.rememberapptakethree.MainApplication
import com.swright.rememberapptakethree.room.models.ThingToRemember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RememberViewModel(screenTitle: String): ViewModel() {

    val rememberDao = MainApplication.rememberDatabase.getRememberDao()

    var rememberList: LiveData<List<ThingToRemember>> = rememberDao.getThingsToRememberByCategory(screenTitle)
//    var rememberList: LiveData<List<ThingToRemember>> = listOf()

    fun getThingsToRememberByCategory(thingToRememberCategory: String) {
        viewModelScope.launch(Dispatchers.IO) {
            rememberList = rememberDao.getThingsToRememberByCategory(thingToRememberCategory)
        }
    }

    fun addThingToRemember(title: String, category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            rememberDao.addThingToRemember(ThingToRemember(title = title, thingToRememberCategory = category))
        }
    }

    fun deleteThingToRemember(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            rememberDao.deleteThingToRemember(id = id)
        }
    }
}