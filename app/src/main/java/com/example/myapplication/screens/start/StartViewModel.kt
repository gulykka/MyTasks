package com.example.myapplication.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY
import com.example.myapplication.REPOSITOTYLIST
import com.example.myapplication.db.TasksDatabase
import com.example.myapplication.db.repositories.ListRealization
import com.example.myapplication.db.repositories.TaskRealization
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StartViewModel(application: Application):AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoTask = TasksDatabase.getInstance(context).getTaskDao()
        val daoList = TasksDatabase.getInstance(context).getListDao()
        REPOSITORY = TaskRealization(daoTask)
        REPOSITOTYLIST = ListRealization(daoList)
    }
    fun getAllTasks():LiveData<List<TaskModel>>{
        return REPOSITORY.allTasks
    }

    fun getAllLists():LiveData<List<ListModel>> {
        return REPOSITOTYLIST.allLists
    }



    public fun update(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITORY.updateTask(taskModel){
                onSuccess()
            }
        }
}