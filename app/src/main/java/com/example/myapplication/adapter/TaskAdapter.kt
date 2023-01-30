package com.example.myapplication.adapter

import  android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.models.TaskModel
import com.example.myapplication.screens.start.StartFragment
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
        holder.itemView.checkBox_is_chosen.setOnClickListener{
            Toast.makeText(APP, "" + position, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.checkBox_is_performed.setOnClickListener{
            Toast.makeText(APP, "" + position, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<TaskModel>) {
        listTask = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: TaskViewHolder) {
        super.onViewAttachedToWindow(holder)

        holder.itemView.setOnClickListener{
            StartFragment.changeTask(listTask[holder.adapterPosition])
        }

        holder.itemView.setOnClickListener{
            StartFragment.clickTask(listTask[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: TaskViewHolder) {
        holder.itemView.setOnClickListener(null)

    }
}