package com.example.viewbindinglesson

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindinglesson.databinding.CategoryListItemBinding

class CategoryAdapter(val context:Context, var categories:List<Category>):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CategoryListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = categories[position]
        holder.tvCategoryName.text = category.name
        holder.tvSubTitle.text = category.subTitle
    }

    fun updateList(filteredList: List<Category>) {
        categories = filteredList
    }

    class MyViewHolder(private val binding: CategoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvCategoryName = binding.tvCategoryName
        val tvSubTitle = binding.tvSubTitle
    }
}