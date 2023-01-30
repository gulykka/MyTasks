package com.example.myapplication.db.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.models.TaskModel

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskModel: TaskModel)

    @Delete
    suspend fun delete(taskModel: TaskModel)

    @Update
    suspend fun update(taskModel: TaskModel)

    @Query("SELECT * FROM task_table")
    fun getAllTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE number_list IS NULL")
    fun getMyTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE chosen = 1")
    fun getChosenTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE number_list = :id")
    fun getListTasks(id: Int):LiveData<List<TaskModel>>






}