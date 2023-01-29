package com.example.myapplication.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.REPOSITORY
import com.example.myapplication.db.TasksDatabase
import com.example.myapplication.db.repositories.TaskRealization
import com.example.myapplication.db.repositories.TaskRepository
import com.example.myapplication.models.TaskModel

class StartViewModel(application: Application):AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoTask = TasksDatabase.getInstance(context).getTaskDao()
        REPOSITORY = TaskRealization(daoTask)
    }
    fun getAllTasks():LiveData<List<TaskModel>>{
        return REPOSITORY.allTasks
    }
}