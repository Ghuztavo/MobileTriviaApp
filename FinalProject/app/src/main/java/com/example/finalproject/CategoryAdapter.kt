package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    lateinit var categoryButton: Button

    init
    {
        categoryButton = itemView.findViewById(R.id.categoryButton)
    }
}

class CategoryAdapter( val listener: OnCategoryClickedListener): RecyclerView.Adapter<CategoryViewHolder>()
{
    override fun getItemCount(): Int = AppData.categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder
    {
        val ll = LayoutInflater.from(parent.context).inflate(R.layout.categories_layout, parent, false)
        return CategoryViewHolder(ll)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int)
    {
        holder.categoryButton.text = AppData.categories[position].name
        holder.categoryButton.setOnClickListener {
            listener.onGroupClicked(position)
        }

    }
}