package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import Numres.ELBAHRI.pizzaapp.model.Purchase
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.viewmodel.PizzaViewModel

@Composable
fun HistoryScreen(viewModel: PizzaViewModel) {
    // Collect the purchase history from the ViewModel
    val purchaseHistory by viewModel.purchaseHistory.collectAsState(initial = emptyList())

    if (purchaseHistory.isEmpty()) {
        // Display a message if the history is empty
        Text(
            text = "Aucun historique de commandes trouvé",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        // Display the list of purchases
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(purchaseHistory) { purchase ->
                PurchaseCard(purchase = purchase)
            }
        }
    }
}

@Composable
fun PurchaseCard(purchase: Purchase, modifier: Modifier = Modifier) {
    // Deserialize the pizza list from JSON
    val pizzas = deserializePizzas(purchase.items)

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Date: ${formatDate(purchase.date)}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Total: ${purchase.total} €",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Détails :",
                style = MaterialTheme.typography.bodyLarge
            )
            // Display each pizza in the order
            pizzas.forEach { pizza ->
                Text(
                    text = "- ${pizza.name}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// Helper function to deserialize a JSON string to a list of pizzas
fun deserializePizzas(json: String): List<Pizza> {
    val type = object : TypeToken<List<Pizza>>() {}.type
    return Gson().fromJson(json, type)
}

// Helper function to format a timestamp into a readable date
fun formatDate(timestamp: Long): String {
    val sdf = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
    return sdf.format(timestamp)
}
