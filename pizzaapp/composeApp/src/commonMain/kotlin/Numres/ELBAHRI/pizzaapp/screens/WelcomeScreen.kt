package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import Numres.ELBAHRI.pizzaapp.data.PizzaImageProvider

// Import Android
import androidx.compose.ui.res.painterResource

// Import Web
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.attributes.attr

@Composable
fun WelcomeScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF7E8D7)
    val buttonColor = Color(0xFF008000)
    val textColor = Color(0xFFB22222)

    val imageProvider = PizzaImageProvider()
    val logoImage = imageProvider.getImageResource(0) // Supposons que l'ID 0 soit le logo

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Affichage de l'image en fonction de la plateforme
            when (logoImage) {
                is Int -> { // Android
                    Image(
                        painter = painterResource(id = logoImage),
                        contentDescription = "Logo Pizza SAW",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(4.dp, buttonColor, CircleShape)
                    )
                }
                is String -> { // Web
                    Img(
                        src = logoImage,
                        alt = "Logo Pizza SAW",
                        attrs = { attr("width", "200px") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Bienvenue chez Pizza SAW!",
                style = MaterialTheme.typography.headlineMedium,
                color = textColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("pizza_list") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Voir le Menu", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("caddy") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Voir le Panier", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("history") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Historique des Achats", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
