package com.example.buoi9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(
    private val listStudent: List<Student>
) : Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : ViewHolder(view) {
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvAge = view.findViewById<TextView>(R.id.tvAge)
        val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int = listStudent.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        with(holder) {
            tvId.text = listStudent[position].id
            tvName.text = listStudent[position].name
            tvAge.text = listStudent[position].age.toString()
            tvAddress.text = listStudent[position].address
        }
    }
}