package com.example.todoapp.data

import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
){
    fun getAll() = todoDao.getAll()
}