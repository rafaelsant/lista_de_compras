package com.example.listadecompras.data

import com.example.listadecompras.GroceryAdapter

class DataSource(private val groceryAdapter: GroceryAdapter) {
    private var groceries:List<GroceryModel> = emptyList()

    fun addGrocery(groceryModel: GroceryModel){
        this.groceries = groceries.plus(groceryModel)
        groceryAdapter.notifyDataSetChanged()
    }

    fun removeGrocery(id:String){
        this.groceries = groceries.filter { it.id != id }
        groceryAdapter.notifyDataSetChanged()
    }

    fun updateTodo(groceryModel: GroceryModel){
        this.groceries.first { it.id == groceryModel.id }.apply {
            this.done = groceryModel.done
            this.title = groceryModel.title
        }
        groceryAdapter.notifyDataSetChanged()
    }

    fun getGroceryList(): List<GroceryModel> {
        return this.groceries
    }
}