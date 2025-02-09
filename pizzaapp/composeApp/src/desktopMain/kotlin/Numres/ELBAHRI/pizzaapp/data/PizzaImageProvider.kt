package Numres.ELBAHRI.pizzaapp.data

// TEMPORAIRE : Suppression de l'implémentation pour Desktop/Web

actual class PizzaImageProvider {
    actual fun getImageResource(pizzaId: Int): Any {
        throw NotImplementedError("Desktop/Web désactivés pour l'instant")
    }
}
