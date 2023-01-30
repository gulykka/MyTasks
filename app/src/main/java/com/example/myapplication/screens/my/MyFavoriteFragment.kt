package com.example.myapplication.screens.my

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.adapter.TaskAdapter
import com.example.myapplication.databinding.FragmentMyFavoriteBinding
import com.example.myapplication.models.TaskModel

class MyFavoriteFragment : Fragment() {

    lateinit var binding: FragmentMyFavoriteBinding
    lateinit var adapter_task: TaskAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        adapter_task = TaskAdapter()
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter_task

        val viewModel = ViewModelProvider(this)[MyFavoriteViewModel::class.java]
        viewModel.initDatabase()

        viewModel.getChosenTasks().observe(viewLifecycleOwner) { listTasks ->
            adapter_task.setList(listTasks.reversed())
        }
        binding.buttonBack.setOnClickListener {
            APP.navController.navigate(R.id.action_myFavoriteFragment_to_startFragment)
        }

    }


    companion object {
        fun clickTask(taskModel: TaskModel) {
            val bundle = Bundle()
            Log.e("AAA", "666")
            bundle.putSerializable("task", taskModel)
            APP.navController.navigate(R.id.action_myFavoriteFragment_to_detailFragment, bundle)

        }
    }
}

