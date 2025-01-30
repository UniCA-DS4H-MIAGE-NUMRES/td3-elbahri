package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.viewmodel.PizzaViewModel
import androidx.navigation.NavController

@Composable
fun DetailPizza(
    pizza: Pizza,
    modifier: Modifier = Modifier,
    viewModel: PizzaViewModel,
    navController: NavController
) {
    val extraCheese = remember { mutableStateOf(0) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.addPizzaToCart(pizza = pizza, extraCheese = extraCheese.value)
                navController.navigate("caddy")
            }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Order"
                )
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = pizza.image),
                    contentDescription = pizza.name,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = pizza.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Price: $${pizza.price}"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Extra Cheese: ${extraCheese.value}"
                )
                Slider(
                    value = extraCheese.value.toFloat(),
                    onValueChange = { extraCheese.value = it.toInt() },
                    valueRange = 0f..5f,
                    steps = 4
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("caddy") }) {
                    Text(text = "Voir le caddy")
                }
                // Exemple de navigation depuis un écran de liste de pizzas
                Button(
                    onClick = { navController.navigate("customize_pizza/${pizza.id}") },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Personnaliser")
                }
            }
        }
    )
}

