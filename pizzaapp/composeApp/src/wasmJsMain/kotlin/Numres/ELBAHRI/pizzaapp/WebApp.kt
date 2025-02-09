package Numres.ELBAHRI.pizzaapp

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.renderComposable
import Numres.ELBAHRI.pizzaapp.screens.PizzaMenu
import Numres.ELBAHRI.pizzaapp.data.DataSource

fun main() {
    renderComposable(rootElementId = "root") {
        MyWebApp()
    }
}

@Composable
fun MyWebApp() {
    val pizzas = DataSource().loadPizzas()
    PizzaMenu(menu = pizzas, navController = null) // Pas besoin de `NavController` sur Web
}
