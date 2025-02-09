package Numres.ELBAHRI.pizzaapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import Numres.ELBAHRI.pizzaapp.model.Purchase

@Dao
interface PurchaseDao {
    @Insert
    suspend fun insertPurchase(purchase: Purchase): Long

    @Query("SELECT * FROM purchases")
    fun getAllPurchases(): Flow<List<Purchase>>
}
