package com.example.myapplication.screens.start

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
import com.example.myapplication.databinding.FragmentStartBinding



class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var adapter: TaskAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDatabase()
        recyclerView = binding.rvTasks
        adapter = TaskAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllTasks().observe(viewLifecycleOwner) { listTasks ->
            adapter.setList(listTasks.reversed())
        }


        binding.buttonNewTask.setOnClickListener {
            Log.e("AAA", "666")
            APP.navController.navigate(R.id.action_startFragment_to_addTaskFragment2)
        }
    }

}