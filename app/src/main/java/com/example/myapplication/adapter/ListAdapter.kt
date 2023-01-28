package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel
import kotlinx.android.synthetic.main.list.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var listList = emptyList<ListModel>()

    class ListViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.list_title.text = listList[position].title_list
    }

    override fun getItemCount(): Int {
        return listList.size
    }

    fun setList(list:List<ListModel>) {
        listList = list
        notifyDataSetChanged()
    }

}