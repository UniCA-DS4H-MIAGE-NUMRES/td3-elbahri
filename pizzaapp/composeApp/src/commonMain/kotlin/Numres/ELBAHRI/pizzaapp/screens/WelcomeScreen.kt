package Numres.ELBAHRI.pizzaapp.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import Numres.ELBAHRI.pizzaapp.R

@Composable
fun WelcomeScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF7E8D7)
    val buttonColor = Color(0xFF008000)
    val textColor = Color(0xFFB22222)

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

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Pizza SAW",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(4.dp, buttonColor, CircleShape)
            )

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