package com.swright.rememberapptakethree.room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.swright.rememberapptakethree.room.models.ThingToRemember
import java.util.Locale.Category

@Dao
interface RememberDao {

    @Query("SELECT * FROM ThingToRemember")
    fun getAllThingsToRemember(): LiveData<List<ThingToRemember>>

    @Query("SELECT * FROM ThingToRemember where thingToRememberCategory = :category")
    fun getThingsToRememberByCategory(category: String): LiveData<List<ThingToRemember>>

    @Insert
    fun addThingToRemember(thingToRemember: ThingToRemember)

    @Query("DELETE FROM ThingToRemember WHERE ID = :id")
    fun deleteThingToRemember(id: Int)
}