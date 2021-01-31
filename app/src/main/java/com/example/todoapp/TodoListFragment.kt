package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.adapter.TodoListAdapter
import com.example.todoapp.databinding.FragmentTodoListBinding
import com.example.todoapp.model.TodoListViewModel

class TodoListFragment : Fragment() {
    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.todoNewButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_todoListFragment_to_todoNewFragment)
        }

        val adapter = TodoListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)
        adapter.submitList(viewModel.todoList)

        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}