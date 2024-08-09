package com.example.roompractice.Models.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.roompractice.Models.User


@Database(
    entities = [User::class],
    version = 3,
    )
abstract class UserDatabase : RoomDatabase() {
    abstract val dao : User_DAO

    companion object
    {
       fun getInstance(context: Context) = databaseBuilder(
           context.applicationContext,
           UserDatabase::class.java, "user_database")
           .fallbackToDestructiveMigration()
           .build()
    }
}