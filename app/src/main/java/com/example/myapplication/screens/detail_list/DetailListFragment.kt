package com.example.myapplication.screens.detail_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailListBinding
import com.example.myapplication.models.ListModel
import com.example.myapplication.screens.detail_list.DetailListViewModel


class DetailListFragment : Fragment() {

    lateinit var binding: FragmentDetailListBinding
    lateinit var currentList: ListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailListBinding.inflate(layoutInflater, container, false)
        currentList = arguments?.getSerializable("list") as ListModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailListViewModel::class.java)

        binding.titleList.setText(currentList.title_list)

        binding.buttonBack.setOnClickListener{
            val title_new = binding.titleList.text.toString()
            val updateList = ListModel(currentList.id_list, title_list = title_new)
            viewModel.update( updateList){}
            APP.navController.navigate(R.id.action_detailListFragment2_to_startFragment)
        }

        binding.buttonDeleteList.setOnClickListener{
            viewModel.delete(currentList){}
            APP.navController.navigate(R.id.action_detailListFragment2_to_startFragment)
        }

        binding.buttonNewTask.setOnClickListener{
            APP.navController.navigate(R.id.action_detailListFragment2_to_addTaskFragment,)
        }
    }

    companion object

}