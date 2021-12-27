package com.example.listadecompras.model

import android.app.Application
import com.example.listadecompras.db.ProductDatabase
import kotlinx.coroutines.InternalCoroutinesApi

class ListaDeComprasApplication: Application() {

    @InternalCoroutinesApi
    val database: ProductDatabase by lazy {
        try {
            ProductDatabase.getDatabase(this)
        } catch (error: Exception){
            throw  error
        }
    }
}