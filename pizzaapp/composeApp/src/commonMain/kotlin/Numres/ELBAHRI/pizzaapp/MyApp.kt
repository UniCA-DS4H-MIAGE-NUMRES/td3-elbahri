package Numres.ELBAHRI.pizzaapp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyApp() {
    var text by remember { mutableStateOf("Bienvenue sur PizzaApp !") }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { text = "Bon appétit ! 🍕" }) {
                    Text("Commander une pizza")
                }
            }
        }
    }
}
