package com.example.todoapp.data

import android.graphics.Color

data class ColorPickerPair(val name:String, val colorHex:String){
    val color: Int get() = Color.parseColor(colorHex)
}