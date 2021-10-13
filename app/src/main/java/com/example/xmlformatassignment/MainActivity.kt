package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var studentsList: List<Student>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val parser = MyXmlPullParserHandler()
            val stream = assets.open("studentdetails.xml")
            studentsList = parser.parse(stream)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //initialize recyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UsersAdapter(studentsList,this)
    }
}