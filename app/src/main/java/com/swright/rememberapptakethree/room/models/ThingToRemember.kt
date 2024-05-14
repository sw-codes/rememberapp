package com.swright.rememberapptakethree.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ThingToRemember(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var thingToRememberCategory: String
)
