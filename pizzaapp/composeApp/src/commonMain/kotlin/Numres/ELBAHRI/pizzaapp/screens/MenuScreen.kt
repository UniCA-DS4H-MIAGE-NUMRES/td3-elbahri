// app/src/main/java/Numres/ELBAHRI/pizzaapp/screens/MenuScreen.kt
package Numres.ELBAHRI.pizzaapp.screens

import Numres.ELBAHRI.pizzaapp.R
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.ui.theme.BackgroundColor
import Numres.ELBAHRI.pizzaapp.ui.theme.ButtonColor
import Numres.ELBAHRI.pizzaapp.ui.theme.TextColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PizzaMenu(
    menu: List<Pizza>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(modifier = modifier.background(BackgroundColor)) {
        items(menu) { pizza ->
            PizzaCard(
                pizza = pizza,
                modifier = Modifier.padding(16.dp),
                onClickPizza = {
                    navController.navigate("pizza_detail/${menu.indexOf(pizza)}")
                }
            )
        }
    }
}

@Composable
fun PizzaCard(pizza: Pizza, modifier: Modifier = Modifier, onClickPizza: () -> Unit = {}) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClickPizza)
            .background(ButtonColor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = pizza.image),
                contentDescription = pizza.name,
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = pizza.name,
                style = MaterialTheme.typography.headlineMedium,
                color = TextColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Prix = ${pizza.price} €",
                style = MaterialTheme.typography.bodyLarge,
                color = TextColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}