package com.swright.rememberapptakethree.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swright.rememberapptakethree.room.models.ThingToRemember

@Database(
    entities = [ThingToRemember::class],
    version = 2
)
abstract class RememberDatabase: RoomDatabase() {

    companion object {
        const val NAME = "Remember_db"
    }

    abstract fun getRememberDao(): RememberDao
}