package com.example.myapplication.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {
    fun delete(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITORY.deleteTask(taskModel){
                onSuccess()
            }
        }

    fun update(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITORY.updateTask(taskModel){
                onSuccess()
            }
        }

}