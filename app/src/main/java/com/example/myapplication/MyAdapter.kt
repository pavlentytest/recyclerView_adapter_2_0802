package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyView>() {
    class MyView(item: View) : RecyclerView.ViewHolder(item) {
        val name: TextView = item.findViewById(R.id.textView)
        val sex: TextView = item.findViewById(R.id.textView2)
        val phone: TextView = item.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
       return MyView(view)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.name.text = list.get(position).name
        holder.sex.text = list.get(position).sex.toString()
        holder.phone.text = list.get(position).phoneNumber
    }
}