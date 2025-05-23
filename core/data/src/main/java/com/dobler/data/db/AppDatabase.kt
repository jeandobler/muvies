package com.dobler.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dobler.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): MovieDao
}
