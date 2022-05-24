package com.example.listadecompras.data

import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistry
import java.time.LocalDateTime

data class GroceryModel (
    val id:String,
    var title:String,
    var done:Boolean = false
): ViewModel()
