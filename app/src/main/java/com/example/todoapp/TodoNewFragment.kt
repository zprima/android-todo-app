package com.example.todoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todoapp.adapter.ColorSpinnerAdapter
import com.example.todoapp.data.ColorPickerPair
import com.example.todoapp.databinding.FragmentTodoNewBinding
import com.example.todoapp.model.EventMessage
import com.example.todoapp.model.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoNewFragment : Fragment() {
    private var _binding: FragmentTodoNewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoNewBinding.inflate(inflater, container, false)

        binding.saveButton.setOnClickListener { view -> onSaveButtonClicked(view) }

        viewModel.eventStatus.observe(viewLifecycleOwner) {
            when(it){
                is EventMessage.EVENT_OK -> {
                    Log.d("mijagi", "After Event observed")
                    findNavController().navigateUp()
                }
                else -> {

                }
            }
        }

        val items = listOf(
            ColorPickerPair("Red", "#FF0000"),
            ColorPickerPair("Green", "#00FF00"),
            ColorPickerPair("Blue", "#0000FF")
        )
        val adapter = ColorSpinnerAdapter(requireContext(), R.layout.color_dropdown_item, items)
        binding.colorSpinner.adapter = adapter

        return binding.root
    }

    private fun onSaveButtonClicked(view: View) {
        //hide the keyboard
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        //save in db
        lifecycleScope.launch {
            viewModel.createTodo(binding.todoTitle.text.toString())
            Log.d("mijagi","After view model call")
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}