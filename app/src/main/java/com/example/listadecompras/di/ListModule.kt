package com.example.listadecompras.model

import androidx.room.Room
import com.example.listadecompras.db.ProductDao
import com.example.listadecompras.db.ProductDatabase
import com.example.listadecompras.db.ProductRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        Room.databaseBuilder(get(), ProductDatabase::class.java, "product_database")
            .build()
    }

    single { get<ProductDatabase>().productDao() }

    single { ProductRepository(get()) }

    viewModel {
         MyListViewModel(get())
    }
}