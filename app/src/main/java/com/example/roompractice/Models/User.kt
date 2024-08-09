package com.example.roompractice.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.roompractice.Models.Room.Converters

@Entity(tableName = "user_records")
@TypeConverters(Converters::class)
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val name : String,
    val city : String,
    val dateTime: DateTime
)

data class DateTime(val date : String, val time : String)
