package com.example.xmlformatassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_item.view.*


class UsersAdapter(private val studentsList: List<Student>, private val context: Context) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentNameTextView: TextView = itemView.tv_studentName
        val studentMarksTextView: TextView = itemView.tv_studentMarks
        val studentIDTextView: TextView = itemView.tv_studentID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_item,
            parent,
            false
        )
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val studentName = studentsList[position].name
        val studentMarks = studentsList[position].marks
        val studentID = studentsList[position].id
        holder.studentNameTextView.text = studentName
        holder.studentMarksTextView.text = studentMarks.toString()
        holder.studentIDTextView.text = studentID.toString()
//        holder.userItemLinearLayout.setOnClickListener {
//            val intent = Intent(context, EditActivity::class.java)
//            intent.putExtra("userName", userName)
//            intent.putExtra("userLocation", userLocation)
//            intent.putExtra("pk", pk)
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount() = studentsList.size
}