package com.example.listadecompras.db

import androidx.room.*
import com.example.listadecompras.model.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: ProductEntity)

    @Update
    suspend fun update(product: ProductEntity)

    @Query( "DELETE from products WHERE id = :id")
    suspend fun deleteProduct(id: Long)

    @Query("SELECT * from products WHERE id= :id")
    fun getProduct(id: Long): Flow<ProductEntity>

    @Query("SELECT * from products ORDER BY name ASC")
    fun getAllProducts(): Flow<List<ProductEntity>>

}