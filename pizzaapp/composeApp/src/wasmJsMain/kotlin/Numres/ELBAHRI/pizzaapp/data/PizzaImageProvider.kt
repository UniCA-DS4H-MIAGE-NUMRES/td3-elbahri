package Numres.ELBAHRI.pizzaapp.data

actual class PizzaImageProvider {
    actual fun getImageResource(pizzaId: Int): String {
        return "images/pizza$pizzaId.png"
    }
}
