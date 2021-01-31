package com.example.todoapp.data

import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
){
    fun getAll() = todoDao.getAll()

    suspend fun add(todo: Todo) = todoDao.add(todo)

    suspend fun delete(todo: Todo) = todoDao.delete(todo)
}