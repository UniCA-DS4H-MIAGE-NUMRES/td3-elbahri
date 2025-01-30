package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.ui.theme.ButtonColor

@Composable
fun CustomizePizzaScreen(
    pizza: Pizza,
    onAddToCart: (Pizza, Int) -> Unit,
    cartItems: List<Pizza>,
    totalPrice: Double,
    navController: NavController
) {
    var selectedDough by remember { mutableStateOf("Thin Crust") }
    var extraCheese by remember { mutableStateOf(0) }
    val selectedIngredients = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Customize your ${pizza.name}", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Dough selection
        Text(text = "Select Dough Type", style = MaterialTheme.typography.bodyLarge)
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedDough == "Thin Crust",
                    onClick = { selectedDough = "Thin Crust" }
                )
                Text(text = "Thin Crust")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedDough == "Thick Crust",
                    onClick = { selectedDough = "Thick Crust" }
                )
                Text(text = "Thick Crust")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Extra cheese selection
        Text(text = "Add Extra Cheese", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = extraCheese.toFloat(),
            onValueChange = { extraCheese = it.toInt() },
            valueRange = 0f..5f,
            steps = 4
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ingredient selection
        Text(text = "Select Ingredients", style = MaterialTheme.typography.bodyLarge)
        pizza.ingredients.forEach { ingredient ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedIngredients.contains(ingredient),
                    onCheckedChange = {
                        if (it) selectedIngredients.add(ingredient) else selectedIngredients.remove(ingredient)
                    }
                )
                Text(text = ingredient)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add to cart button
        Button(
            onClick = { onAddToCart(pizza, extraCheese) },
            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor) // Use the green color from the theme
        ) {
            Text(text = "Add to Cart")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // View cart button
        Button(
            onClick = { navController.navigate("caddy") },
            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor) // Use the green color from the theme
        ) {
            Text(text = "View Cart")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display cart items
        Text(text = "Your Cart", style = MaterialTheme.typography.headlineMedium)
        LazyColumn {
            items(cartItems) { cartPizza ->
                Text(text = "${cartPizza.name} - ${cartPizza.price} €")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display total price
        Text(text = "Total Price: $totalPrice €", style = MaterialTheme.typography.headlineSmall)
    }
}