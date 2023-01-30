package com.example.myapplication.db.repositories

import androidx.lifecycle.LiveData
import com.example.myapplication.models.ListModel


interface ListRepository {

    val allLists: LiveData<List<ListModel>>

    suspend fun insertList(listModel: ListModel, onSuccess:() -> Unit)
    suspend fun deleteList(listModel: ListModel, onSuccess:() -> Unit)
    suspend fun updateList(listModel: ListModel, onSuccess:() -> Unit)
}