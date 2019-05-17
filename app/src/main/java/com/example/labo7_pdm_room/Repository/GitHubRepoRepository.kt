package com.example.labo7_pdm_room.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_pdm_room.database.GithubDAO
import com.example.labo7_pdm_room.database.GithubRepo

class GitHubRepoRepository (private val repoDao: GithubDAO) {

    @WorkerThread
    suspend fun insert (repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}