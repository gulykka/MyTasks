package com.example.myapplication.db.repositories

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.ListDao
import com.example.myapplication.models.ListModel

class ListRealization(private val listDao: ListDao): ListRepository{

    override val allLists: LiveData<List<ListModel>>
        get() = listDao.getAllLists()

    override suspend fun insertList(listModel: ListModel, onSuccess: () -> Unit) {
        listDao.insert(listModel)
        onSuccess()
    }

    override suspend fun deleteList(listModel: ListModel, onSuccess: () -> Unit) {
        listDao.delete(listModel)
        onSuccess()
    }

    override suspend fun updateList(listModel: ListModel, onSuccess: () -> Unit) {
        listDao.update(listModel)
        onSuccess()
    }


}