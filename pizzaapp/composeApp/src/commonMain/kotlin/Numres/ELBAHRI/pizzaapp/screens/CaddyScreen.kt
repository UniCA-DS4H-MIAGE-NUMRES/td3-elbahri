package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import Numres.ELBAHRI.pizzaapp.model.Pizza

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaddyScreen(
    navController: NavController,
    cartItems: List<Pizza>,
    totalPrice: Double,
    onCheckoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Define the same colors as in WelcomeScreen
    val backgroundColor = Color(0xFFF7E8D7) // Soft background color
    val buttonColor = Color(0xFF008000) // Green for the button
    val textColor = Color(0xFFB22222) // Red for the texts

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(buttonColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Votre Caddy",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }
        },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Check if the cart is empty
                if (cartItems.isEmpty()) {
                    Text(
                        text = "Votre caddy est vide.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor
                    )
                } else {
                    // List of pizzas in the cart
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        items(cartItems) { pizza ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(
                                        text = pizza.name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = textColor
                                    )
                                    Text(
                                        text = "Prix: ${pizza.price} €",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = textColor
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Display total price
                    Text(
                        text = "Prix Total: €$totalPrice",
                        style = MaterialTheme.typography.headlineSmall,
                        color = textColor
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Button to validate the order
                    Button(
                        onClick = {
                            onCheckoutClick()
                            navController.navigate("confirmation")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Passer la commande", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    )
}