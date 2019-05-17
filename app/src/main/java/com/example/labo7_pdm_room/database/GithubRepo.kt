package com.example.labo7_pdm_room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "repos")
class GithubRepo(
    @ColumnInfo(name="s_name")
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long=0
}