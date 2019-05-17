package com.example.labo7_pdm_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase() {

    abstract fun repoDao():GithubDAO

    companion object {
        private var INSTANCE: RoomDB?=null

        fun getInstace(context: Context):RoomDB{
            val tempInstance= INSTANCE
            if(tempInstance!=null) return tempInstance
            synchronized(this){
                val instance= Room
                    .databaseBuilder(context, RoomDB::class.java, "RepoDB")
                    .build()
                return instance
            }
        }
    }
}