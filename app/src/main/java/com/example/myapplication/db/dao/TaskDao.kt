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

    @Query("SELECT * FROM task_table WHERE is_chosen = 'true'")
    fun getChosenTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE number_list = 0 ")
    fun getMyTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE is_performed = 'true'")
    fun getPerformedTasks():LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_table WHERE is_performed = 'false'")
    fun getNotPerformedTasks():LiveData<List<TaskModel>>
}