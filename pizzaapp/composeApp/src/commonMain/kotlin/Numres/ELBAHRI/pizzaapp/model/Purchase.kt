package Numres.ELBAHRI.pizzaapp.model



import kotlinx.serialization.Serializable

@Serializable
data class Purchase(
    val id: Int = 0,  // Géré différemment sur Android avec Room
    val date: Long,
    val total: Double,
    val items: String  // JSON contenant la liste des pizzas achetées
)
