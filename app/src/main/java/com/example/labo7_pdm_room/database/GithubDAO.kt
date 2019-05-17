package com.example.labo7_pdm_room.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface GithubDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query("SELECT * FROM repos")
    fun getAllRepos(): LiveData<List<GithubRepo>>


    @Query("DELETE FROM repos")
    fun nukeTable()
}