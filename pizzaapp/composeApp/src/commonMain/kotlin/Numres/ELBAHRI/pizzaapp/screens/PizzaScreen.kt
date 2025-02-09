package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.viewmodel.PizzaViewModel
import androidx.navigation.NavController
import Numres.ELBAHRI.pizzaapp.data.PizzaImageProvider

// Import Web
import androidx.compose.ui.res.painterResource
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.attributes.attr

@Composable
fun DetailPizza(
    pizza: Pizza,
    modifier: Modifier = Modifier,
    viewModel: PizzaViewModel,
    navController: NavController
) {
    val extraCheese = remember { mutableStateOf(0) }
    val imageProvider = PizzaImageProvider()
    val image = imageProvider.getImageResource(pizza.id)

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
                // Affichage de l'image en fonction de la plateforme
                when (image) {
                    is Int -> { // Android
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = pizza.name,
                            modifier = Modifier
                                .size(400.dp)
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                    is String -> { // Web
                        Img(
                            src = image,
                            alt = pizza.name,
                            attrs = { attr("width", "400px") }
                        )
                    }
                }

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
