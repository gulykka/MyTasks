package com.example.myapplication.db.repositories

import androidx.lifecycle.LiveData
import com.example.myapplication.models.ListModel


interface ListRepository {

    val allLists: LiveData<List<ListModel>>

    suspend fun insertList(taskModel: ListModel, onSuccess:() -> Unit)
    suspend fun deleteList(taskModel: ListModel, onSuccess:() -> Unit)
    suspend fun updateList(taskModel: ListModel, onSuccess:() -> Unit)
}