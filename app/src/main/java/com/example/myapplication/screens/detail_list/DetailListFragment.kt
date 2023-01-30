package com.example.myapplication.screens.detail_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.adapter.TaskAdapter
import com.example.myapplication.databinding.FragmentDetailListBinding
import com.example.myapplication.models.ListModel
import com.example.myapplication.screens.detail_list.DetailListViewModel


class DetailListFragment : Fragment() {

    lateinit var binding: FragmentDetailListBinding
    lateinit var currentList: ListModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter_task: TaskAdapter

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
        recyclerView = binding.rvTasks
        adapter_task = TaskAdapter()
        recyclerView.adapter = adapter_task
        viewModel.getListTasks(currentList.id_list).observe(viewLifecycleOwner) { listTasks ->
            adapter_task.setList(listTasks.reversed())
        }
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
            val bundle = Bundle()
            bundle.putSerializable("list", currentList)
            APP.navController.navigate(R.id.action_detailListFragment2_to_newTaskFragment, bundle)
        }


    }

    companion object

}