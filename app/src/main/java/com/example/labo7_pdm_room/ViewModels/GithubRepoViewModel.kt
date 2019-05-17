package com.example.labo7_pdm_room.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_pdm_room.Repository.GitHubRepoRepository
import com.example.labo7_pdm_room.database.GithubRepo
import com.example.labo7_pdm_room.database.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository: GitHubRepoRepository
    init{
        val repoDao= RoomDB.getInstace(app).repoDao()
        repository= GitHubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}