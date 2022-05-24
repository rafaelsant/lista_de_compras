package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadecompras.data.GroceryModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        grocery_list.layoutManager = LinearLayoutManager(this)
        grocery_list.adapter = GroceryAdapter(this.applicationContext)
    }

    fun addTodo(view: View){
        val adapter = grocery_list.adapter
        var title =  grocery_title.text.toString()
        if(adapter is GroceryAdapter){
            if(title.isNotEmpty()) adapter.dataSource.addGrocery(GroceryModel(id = UUID.randomUUID().toString(),title,false))
            grocery_title.setText("")
        }
    }



}