package com.example.todoapp.model

import android.util.EventLog
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Todo
import com.example.todoapp.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel(){

    private val _eventStatus: MutableLiveData<EventMessage?> = MutableLiveData(null)
    val eventStatus get() = _eventStatus

    fun createTodo(title: String) = viewModelScope.launch{
        val item = Todo(title = title)
        val todoId = todoRepository.add(item)
        Log.d("mijagi","After repository add: $todoId")
        _eventStatus.value = EventMessage.EVENT_OK(message = "$todoId")
    }
}

sealed class EventMessage{
    class EVENT_OK(val message: String): EventMessage()
    class EVENT_FAILED(val message: String): EventMessage()
}