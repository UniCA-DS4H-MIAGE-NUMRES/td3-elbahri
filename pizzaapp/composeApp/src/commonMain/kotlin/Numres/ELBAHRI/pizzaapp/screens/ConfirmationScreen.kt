package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ConfirmationScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF7E8D7)
    val buttonColor = Color(0xFF008000)
    val textColor = Color(0xFFB22222)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Commande validée!",
                style = MaterialTheme.typography.headlineMedium,
                color = textColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("welcome") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Revenir à l'accueil", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}