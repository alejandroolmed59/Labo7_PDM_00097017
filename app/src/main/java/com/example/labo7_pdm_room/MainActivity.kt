package com.example.labo7_pdm_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo7_pdm_room.ViewModels.GithubRepoViewModel
import com.example.labo7_pdm_room.database.GithubRepo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)

        button.setOnClickListener {
            val name= et1.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer {
            Log.d("Lista de repos", "_______________")
            for(repo in it){
                Log.d("LISTA DE REPOS", repo.name)
            }
        })
    }
}
