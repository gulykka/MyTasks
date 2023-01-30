package com.example.myapplication.screens.addlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITOTYLIST
import com.example.myapplication.models.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddListViewModel:ViewModel() {

    fun insert(listModel: ListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO ) {
            REPOSITOTYLIST.insertList(listModel){
                onSuccess()
                Log.e("AAA", "888")

            }
        }
}