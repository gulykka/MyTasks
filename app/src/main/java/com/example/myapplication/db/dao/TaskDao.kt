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

}