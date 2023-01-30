package com.example.myapplication.screens.my

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.REPOSITORY
import com.example.myapplication.REPOSITOTYLIST
import com.example.myapplication.db.TasksDatabase
import com.example.myapplication.db.repositories.ListRealization
import com.example.myapplication.db.repositories.TaskRealization
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel

class MyFavoriteViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoTask = TasksDatabase.getInstance(context).getTaskDao()
        val daoList = TasksDatabase.getInstance(context).getListDao()
        REPOSITORY = TaskRealization(daoTask)
        REPOSITOTYLIST = ListRealization(daoList)
    }
    fun getMyTasks(): LiveData<List<TaskModel>> {
        return REPOSITORY.allMyTasks
    }

    fun getChosenTasks(): LiveData<List<TaskModel>> {
        return REPOSITORY.allChosenTasks
    }
}