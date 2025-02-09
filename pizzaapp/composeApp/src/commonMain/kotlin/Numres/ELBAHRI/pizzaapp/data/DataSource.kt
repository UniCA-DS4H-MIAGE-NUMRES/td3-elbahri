package Numres.ELBAHRI.pizzaapp.data

import Numres.ELBAHRI.pizzaapp.model.Pizza

class DataSource {
    private val imageProvider = PizzaImageProvider()

    fun loadPizzas(): List<Pizza> {
        return listOf(
            Pizza(id = 1, name = "Margherita", price = 8.0, image = imageProvider.getImageResource(1), ingredients = listOf("Tomato", "Mozzarella", "Basil")),
            Pizza(id = 2, name = "Capricciosa", price = 10.0, image = imageProvider.getImageResource(2), ingredients = listOf("Tomato", "Mozzarella", "Ham", "Artichokes", "Mushrooms")),
            Pizza(id = 3, name = "Diavola", price = 9.0, image = imageProvider.getImageResource(3), ingredients = listOf("Tomato", "Mozzarella", "Spicy Salami")),
            Pizza(id = 4, name = "Quattro Stagioni", price = 11.0, image = imageProvider.getImageResource(4), ingredients = listOf("Tomato", "Mozzarella", "Ham", "Artichokes", "Mushrooms", "Olives")),
            Pizza(id = 5, name = "Quattro Formaggi", price = 12.0, image = imageProvider.getImageResource(5), ingredients = listOf("Tomato", "Mozzarella", "Gorgonzola", "Parmesan", "Fontina")),
            Pizza(id = 6, name = "Marinara", price = 7.0, image = imageProvider.getImageResource(6), ingredients = listOf("Tomato", "Garlic", "Oregano")),
            Pizza(id = 7, name = "Pepperoni", price = 9.0, image = imageProvider.getImageResource(7), ingredients = listOf("Tomato", "Mozzarella", "Pepperoni")),
            Pizza(id = 8, name = "Prosciutto", price = 10.0, image = imageProvider.getImageResource(8), ingredients = listOf("Tomato", "Mozzarella", "Prosciutto")),
            Pizza(id = 9, name = "Frutti di Mare", price = 13.0, image = imageProvider.getImageResource(9), ingredients = listOf("Tomato", "Mozzarella", "Seafood"))
        )
    }
}
