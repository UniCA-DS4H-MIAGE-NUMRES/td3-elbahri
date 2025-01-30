package Numres.ELBAHRI.pizzaapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import Numres.ELBAHRI.pizzaapp.data.AppDatabase
import Numres.ELBAHRI.pizzaapp.screens.*
import Numres.ELBAHRI.pizzaapp.viewmodel.PizzaViewModel
import androidx.compose.foundation.layout.padding

@Composable
fun MyApp(context: Context) {
    val navController = rememberNavController()

    // Récupérer la base de données
    val database = AppDatabase.getDatabase(context)
    val purchaseDao = database.purchaseDao()

    // Créer le ViewModel avec la Factory
    val viewModel: PizzaViewModel = viewModel(factory = PizzaViewModel.Factory(purchaseDao))

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }

        composable("pizza_list") {
            PizzaMenu(
                menu = viewModel.getPizzas(),
                modifier = Modifier.padding(16.dp),
                navController = navController
            )
        }

        composable(
            route = "pizza_detail/{idPizza}",
            arguments = listOf(navArgument("idPizza") { type = NavType.IntType })
        ) { backStackEntry ->
            val idPizza = backStackEntry.arguments?.getInt("idPizza") ?: return@composable
            val pizza = viewModel.getPizzaById(idPizza)
            pizza?.let {
                DetailPizza(
                    pizza = it,
                    modifier = Modifier.padding(16.dp),
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }

        composable("caddy") {
            val cartItems by viewModel.cartItems.collectAsState()
            val totalPrice by viewModel.totalPrice.collectAsState()

            CaddyScreen(
                navController = navController,
                cartItems = cartItems,
                totalPrice = totalPrice,
                onCheckoutClick = {
                    viewModel.validateOrder()
                    navController.navigate("confirmation")
                }
            )
        }

        composable("confirmation") {
            ConfirmationScreen(navController = navController)
        }

        composable("history") {
            HistoryScreen(viewModel = viewModel)
        }

        composable(
            route = "customize_pizza/{pizzaId}",
            arguments = listOf(navArgument("pizzaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val pizzaId = backStackEntry.arguments?.getInt("pizzaId")
            val pizza = pizzaId?.let { viewModel.getPizzaById(it) }

            pizza?.let {
                CustomizePizzaScreen(
                    pizza = it,
                    onAddToCart = { pizza, extraCheese ->
                        viewModel.addPizzaToCart(pizza, extraCheese)
                    },
                    cartItems = viewModel.cartItems.collectAsState().value,
                    totalPrice = viewModel.totalPrice.collectAsState().value,
                    navController = navController
                )
            }
        }
    }
}