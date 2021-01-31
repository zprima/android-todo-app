package com.example.todoapp.model

import androidx.lifecycle.*
import com.example.todoapp.data.Todo
import com.example.todoapp.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {
    private var _todoList: LiveData<List<Todo>> = todoRepository.getAll().asLiveData()
    val todoList get() = _todoList //backing field, always expose just readonly variables

    fun onTodoSwipe(item: Todo) = viewModelScope.launch {
        todoRepository.delete(item)
    }
}