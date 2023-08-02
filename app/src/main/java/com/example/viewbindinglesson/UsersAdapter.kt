package com.example.viewbindinglesson

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewbindinglesson.databinding.UserListItemBinding

class UsersAdapter(val context: Context, val users: List<String>) :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {


    class MyViewHolder(private val view: UserListItemBinding) : ViewHolder(view.root) {
        var data = view.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UserListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.data = users[position]
    }
}