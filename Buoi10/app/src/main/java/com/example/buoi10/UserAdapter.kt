package com.example.buoi10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UserAdapter(
    val onItemClick: (view: TextView) -> Unit
) : Adapter<UserAdapter.UserViewHolder>() {

    private var userList = mutableListOf<User>()

    class UserViewHolder(itemView: View) : ViewHolder(itemView) {
        val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvUsername.text = userList[position].username
        holder.tvAddress.text = userList[position].address
        holder.tvAge.text = userList[position].age.toString()

        holder.tvUsername.setOnClickListener { view ->
            onItemClick(view as TextView)
        }
    }

    fun setList(newList: MutableList<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}