package com.example.roompractice

import android.app.Application
import com.example.roompractice.Models.Room.UserDatabase

class RoomPracticeApplication  : Application() {
    val database by lazy { UserDatabase.getInstance(this.applicationContext) }
}