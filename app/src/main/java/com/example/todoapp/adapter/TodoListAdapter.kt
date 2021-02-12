package com.example.todoapp.adapter

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.TodoListItemBinding

class TodoListAdapter: ListAdapter<Todo, RecyclerView.ViewHolder>(TodoDiffCallback()) {

    class ViewHolder(private val binding: TodoListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Todo){
            binding.apply {
                cardTitle.text = item.title
                var background = todoColorDot.background as GradientDrawable
                background.setColor(item.color)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ViewHolder).bind(item)
    }
}

private class TodoDiffCallback: DiffUtil.ItemCallback<Todo>(){
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }

}