package Numres.ELBAHRI.pizzaapp.data

import Numres.ELBAHRI.pizzaapp.R

actual class PizzaImageProvider {
    actual fun getImageResource(pizzaId: Int): Int {
        return when (pizzaId) {
            1 -> R.drawable.pizza1
            2 -> R.drawable.pizza2
            3 -> R.drawable.pizza3
            4 -> R.drawable.pizza4
            5 -> R.drawable.pizza5
            6 -> R.drawable.pizza6
            7 -> R.drawable.pizza7
            8 -> R.drawable.pizza8
            9 -> R.drawable.pizza9
            else -> R.drawable.pizza1
        }
    }
}
