package com.example.myapplication.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.models.TaskModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentTask: TaskModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentTask = arguments?.getSerializable("task") as TaskModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.titleTask.setText(currentTask.title_task)
        binding.descriptionTask.setText(currentTask.description)
        binding.checkBoxTask.isChecked = currentTask.chosen

        binding.buttonDeleteTask.setOnClickListener {
            viewModel.delete(currentTask){}

//            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.buttonBack.setOnClickListener{
            val title_new = binding.titleTask.getText().toString()
            val description_new = binding.descriptionTask.getText().toString()
            val chosen_new = binding.checkBoxTask.isChecked
            val updateTask = TaskModel(currentTask.id_task, title_task = title_new, description = description_new, chosen = chosen_new)
            viewModel.update(updateTask){}
//            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }



    }

}