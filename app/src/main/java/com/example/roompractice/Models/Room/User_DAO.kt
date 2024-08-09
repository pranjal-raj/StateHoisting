package com.example.roompractice.Models.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import androidx.room.Upsert
import com.example.roompractice.Models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface User_DAO {
    @Upsert
    suspend fun upsert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user_records ORDER BY name ASC")
    fun getAllRecordsOrderedByName() : Flow<List<User>>

}