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
import com.example.myapplication.adapter.ListAdapter
import com.example.myapplication.adapter.TaskAdapter
import com.example.myapplication.databinding.FragmentStartBinding
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var adapter_task: TaskAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var adapter_list: ListAdapter
    lateinit var recyclerView_list: RecyclerView


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
        adapter_task = TaskAdapter()
        recyclerView_list = binding.rvList
        adapter_list = ListAdapter()


        recyclerView.adapter = adapter_task
        viewModel.getAllTasks().observe(viewLifecycleOwner) { listTasks ->
            adapter_task.setList(listTasks.reversed())
        }
        recyclerView_list.adapter = adapter_list
        viewModel.getAllLists().observe(viewLifecycleOwner) { listLists ->

            adapter_list.setList(listLists.reversed()
            )
        }


        binding.addNewlistButton.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addListFragment2)
        }

        binding.buttonNewTask.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addTaskFragment2)
        }

        binding.chosenTaskButton.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_myFavoriteFragment)
        }

    }


    companion object {
        fun clickTask(taskModel: TaskModel){
            val bundle = Bundle()
            bundle.putSerializable("task", taskModel)
           APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)

        }

        fun clickList(listModel: ListModel){
            val bundle = Bundle()
            bundle.putSerializable("list", listModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailListFragment2, bundle)

        }
//        fun changeTask(taskModel: TaskModel) {
//            Log.e("AAA", taskModel.id_task.toString())
//            val updateTask = TaskModel(id_task = taskModel.id_task, title_task = taskModel.title_task, chosen = !taskModel.chosen)
//            val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
//            viewModel.initDatabase()
//            viewModel.update(updateTask){}
//        }
//
//        private fun ViewModelProvider(owner: StartFragment.Companion): ViewModelProvider {
//        }
    }


    }

