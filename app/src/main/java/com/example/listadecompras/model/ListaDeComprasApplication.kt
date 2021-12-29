package com.example.listadecompras.model

import android.app.Application
import com.example.listadecompras.db.ProductDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ListaDeComprasApplication: Application() {

    @InternalCoroutinesApi
    val database: ProductDatabase by lazy {
        try {
            ProductDatabase.getDatabase(this)
        } catch (error: Exception){
            throw  error
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ListaDeComprasApplication)
            modules(viewModelModule)
        }
    }
}