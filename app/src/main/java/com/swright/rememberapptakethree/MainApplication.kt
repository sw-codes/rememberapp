package com.swright.rememberapptakethree

import android.app.Application
import androidx.room.Room
import com.swright.rememberapptakethree.room.db.RememberDatabase

class MainApplication: Application() {

    companion object{
        lateinit var rememberDatabase: RememberDatabase
    }

    override fun onCreate() {
        super.onCreate()
        rememberDatabase = Room.databaseBuilder(
            applicationContext,
            RememberDatabase::class.java,
            RememberDatabase.NAME
        ).fallbackToDestructiveMigrationFrom(1).build()
    }
}