package com.example.myapplication.screens.detail_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY
import com.example.myapplication.REPOSITOTYLIST
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailListViewModel: ViewModel() {
    fun delete(listModel: ListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITOTYLIST.deleteList(listModel){
                onSuccess()
            }
        }

    fun update(listModel: ListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITOTYLIST.updateList(listModel){
                onSuccess()
            }
        }
}