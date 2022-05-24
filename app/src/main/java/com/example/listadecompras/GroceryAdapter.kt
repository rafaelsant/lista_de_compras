package com.example.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.data.DataSource
import android.widget.Toast


class GroceryAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    val dataSource= DataSource(this)


    override fun getItemCount()=dataSource.getGroceryList().size.also { println(it) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater.from(parent.context).inflate(R.layout.grocery_card,parent,false)
        return MessageViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = dataSource.getGroceryList()[position]
        if(holder is MessageViewHolder){
            holder.messageTextView.text = currentItem.title
            holder.cardView.setOnLongClickListener {
                Toast.makeText(
                    context,
                    "Item excluído",
                    Toast.LENGTH_SHORT
                ).show().also { dataSource.removeGrocery(currentItem.id) }
                true // <- set to true
            }
            holder.messageCheckboxView.isChecked = currentItem.done
            holder.messageCheckboxView.setOnCheckedChangeListener { _, isChecked -> //set your object's last status
                dataSource.updateTodo(currentItem.copy(done = isChecked))
            }
        }
    }

    class MessageViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val cardView:CardView = itemView.findViewById(R.id.grocery_card)
        val messageCheckboxView:CheckBox = itemView.findViewById(R.id.grocery_check)
        val messageTextView:TextView = itemView.findViewById(R.id.grocery_text)
    }
}