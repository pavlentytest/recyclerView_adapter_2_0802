package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Person(val name: String, val sex: Char, val phoneNumber: String)
class MainActivity : AppCompatActivity() {

    lateinit var persons: List<Person>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fileString = application.assets.open("persons.json").bufferedReader().use{ it.readText()}
        Log.d("RRR",fileString)
        val gson = GsonBuilder().create()
        persons = gson.fromJson(fileString,Array<Person>::class.java).toList()
        Log.d("RRR",persons.get(0).name)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val myAdapter = MyAdapter(persons)
        recyclerView.adapter = myAdapter
    }
}