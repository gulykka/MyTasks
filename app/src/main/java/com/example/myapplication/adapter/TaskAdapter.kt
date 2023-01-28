package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.TaskModel
import kotlinx.android.synthetic.main.task.view.*

class TaskAdapter: RecyclerView.Adapter <TaskAdapter.TaskViewHolder>() {

    var listTask = emptyList<TaskModel>()

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.task_title.text = listTask[position].title_task
        holder.itemView.checkBox_is_chosen.isChecked = listTask[position].chosen
        holder.itemView.checkBox_is_performed.isChecked = listTask[position].performed
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    fun setList(list:List<TaskModel>) {
        listTask = list
        notifyDataSetChanged()
    }
}