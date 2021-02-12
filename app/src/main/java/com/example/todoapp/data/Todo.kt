package com.example.todoapp.data

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val completed: Boolean = false,
    val colorHex: String
) {
    val color: Int get() = Color.parseColor(colorHex)
}
