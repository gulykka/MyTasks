package com.example.myapplication.screens.addlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddListBinding

import com.example.myapplication.models.ListModel


class AddListFragment : Fragment() {

    lateinit var binding: FragmentAddListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddListViewModel::class.java)
        binding.addList.setOnClickListener{
            val title = binding.newList.text.toString()
            viewModel.insert(ListModel(title_list = title)){}
            Log.e("AAA", "111")
            APP.navController.navigate(R.id.action_addListFragment_to_startFragment)
        }
        binding.buttonBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addListFragment_to_startFragment)
        }
    }

}