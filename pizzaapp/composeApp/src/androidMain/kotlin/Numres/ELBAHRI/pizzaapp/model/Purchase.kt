package Numres.ELBAHRI.pizzaapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity(tableName = "purchases")
data class Purchase(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long,
    val total: Double,
    val items: String
)

