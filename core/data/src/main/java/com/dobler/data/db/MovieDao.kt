package com.dobler.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dobler.data.model.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): List<MovieEntity>


    @Query("DELETE FROM movie_table WHERE id = :id")
    suspend fun deleteMovie(id: Int)
}