package Numres.ELBAHRI.pizzaapp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import Numres.ELBAHRI.pizzaapp.ui.theme.PizzaAppTheme
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.screens.PizzaMenu
import Numres.ELBAHRI.pizzaapp.data.DataSource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaAppTheme {
                MyApp(
                    context = this
                )
            }
        }
    }
}


