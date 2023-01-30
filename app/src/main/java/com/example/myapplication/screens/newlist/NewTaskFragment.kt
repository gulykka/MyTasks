package com.example.myapplication.screens.addtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddTaskBinding
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel

class NewTaskFragment : Fragment() {

    lateinit var currentTask: ListModel
    lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(layoutInflater, container, false)
        currentTask = arguments?.getSerializable("list") as ListModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        binding.addTask.setOnClickListener{
            val title = binding.etNewTaskTitle.text.toString()
            val description = binding.etNewTaskDesc.text.toString()
            val title_list = currentTask.id_list
            val chosen = binding.checkBoxIsChosen.isChecked
            viewModel.insert(TaskModel(title_task = title, description = description, chosen = chosen, number_list = title_list)){}
            APP.navController.navigate(R.id.action_newTaskFragment_to_startFragment)
        }
        binding.buttonBack.setOnClickListener{
            APP.navController.navigate(R.id.action_newTaskFragment_to_startFragment)
        }
    }

}