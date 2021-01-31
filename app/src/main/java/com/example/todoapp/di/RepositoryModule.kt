package com.example.todoapp.di

import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository{
        return TodoRepository(todoDao)
    }
}