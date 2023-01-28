package com.example.myapplication.db.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.models.ListModel

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(listModel: ListModel)

    @Delete
    suspend fun delete(listModel: ListModel)

    @Update
    suspend fun update(listModel: ListModel)

    @Query("SELECT * FROM list_table")
    fun getAllTasks(): LiveData<List<ListModel>>
}