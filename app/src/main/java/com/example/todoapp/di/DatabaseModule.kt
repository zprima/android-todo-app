package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.AppDatabase
import com.example.todoapp.data.DATABASE_NAME
import com.example.todoapp.data.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.getInstance(application.applicationContext)
    }

    @Provides
    fun provideTodoDao(database: AppDatabase): TodoDao {
        return database.todoDao()
    }
}