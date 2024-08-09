package com.example.roompractice.Models.Room

import androidx.room.TypeConverter
import com.example.roompractice.Models.DateTime
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromDateTime(value : DateTime) : String = Gson().toJson(value)

    @TypeConverter
    fun fromDateTimeString(value : String) : DateTime = Gson().fromJson(value, DateTime::class.java)
}