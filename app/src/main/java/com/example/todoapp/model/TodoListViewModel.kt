package com.example.todoapp.model

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Todo

class TodoListViewModel : ViewModel() {
    private var _todoList: List<Todo> = populateTodoList()
    val todoList get() = _todoList //backing field, always expose readonly variables only

    private fun populateTodoList(): List<Todo> {
        val listOfTodos = mutableListOf<Todo>()

        repeat(100) {
            listOfTodos.add(Todo(id = it + 1, title = "Todo task ${it+1}"))
        }

        return listOfTodos
    }
}