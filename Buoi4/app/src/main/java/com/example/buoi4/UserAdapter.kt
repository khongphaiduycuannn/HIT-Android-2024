package com.example.buoi4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    var userList: MutableList<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUsername = view.findViewById<TextView>(R.id.tvUsername)
        val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvUsername.text = userList[position].username
        holder.tvAddress.text = userList[position].address

        holder.tvUsername.setOnClickListener {
            Toast.makeText(
                holder.tvUsername.context,
                "${userList[position]}",
                Toast.LENGTH_LONG
            )
                .show()
        }

        holder.tvAddress.setOnClickListener {
            userList.removeAt(position)
            notifyDataSetChanged()
        }
    }
}