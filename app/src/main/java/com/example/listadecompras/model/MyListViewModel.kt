package com.example.listadecompras.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.listadecompras.db.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MyListViewModel(private val repository: ProductRepository): ViewModel() {

    val flow = repository.getAllProducts()

    fun insert(product: ProductEntity){
        viewModelScope.launch {
            repository.insertProduct(product)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch {
            repository.deleteProduct(id)
        }
    }

    fun getAllProducts(): Flow<List<ProductEntity>>{
        return repository.getAllProducts()
    }

    fun addNewProduct(productName: String, productValue: String, productQuantity: String){
        val newProduct = getNewInput(productName, productValue, productQuantity)
        insert(newProduct)
    }

    private fun getNewInput(productName: String, productValue: String, productQuantity: String): ProductEntity{
        return ProductEntity(name = productName, price = productValue.toDouble(), quantity = productQuantity.toInt() )
    }


}

class MyListViewModelFactory(private val repository: ProductRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MyListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}