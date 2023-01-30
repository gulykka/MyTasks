
package com.example.myapplication.screens.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY
import com.example.myapplication.models.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewTaskViewModel:ViewModel() {

    fun insert(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITORY.insertTask(taskModel){
                onSuccess()
            }
        }
}