package com.example.listadecompras.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity (

        @PrimaryKey(autoGenerate = true)
         val id: Long = 0L,
         val name: String = "",
         val price: Double = 0.0,
         val quantity: Int = 0,

        )


