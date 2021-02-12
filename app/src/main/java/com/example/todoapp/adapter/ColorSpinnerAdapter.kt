package com.example.todoapp.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.data.ColorPickerPair
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class ColorSpinnerAdapter(mContext: Context, private val spinnerResource: Int, private val items: List<ColorPickerPair>): ArrayAdapter<ColorPickerPair>(mContext, spinnerResource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val customView = convertView ?: LayoutInflater.from(context).inflate(spinnerResource, parent, false)

        val item = items[position]
        customView.findViewById<MaterialTextView>(R.id.todoColorName).text = item.name

        val colorDot = customView.findViewById<View>(R.id.colorDot)
        val background = colorDot.background as GradientDrawable
        background.setColor(item.color)

        return customView
    }
}