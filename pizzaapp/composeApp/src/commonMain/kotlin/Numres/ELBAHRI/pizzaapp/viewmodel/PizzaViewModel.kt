package Numres.ELBAHRI.pizzaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import Numres.ELBAHRI.pizzaapp.data.PurchaseDao
import Numres.ELBAHRI.pizzaapp.model.Pizza
import Numres.ELBAHRI.pizzaapp.model.Purchase
import Numres.ELBAHRI.pizzaapp.data.DataSource
import com.google.gson.Gson

class PizzaViewModel(private val purchaseDao: PurchaseDao) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<Pizza>>(emptyList())
    val cartItems: StateFlow<List<Pizza>> = _cartItems.asStateFlow()

    private val _totalPrice = MutableStateFlow(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice.asStateFlow()

    private val _purchaseHistory = MutableStateFlow<List<Purchase>>(emptyList())
    val purchaseHistory: StateFlow<List<Purchase>> = _purchaseHistory.asStateFlow()

    private val pizzaList = DataSource().loadPizzas() // Liste des pizzas statiques

    init {
        viewModelScope.launch {
            purchaseDao.getAllPurchases().collectLatest { purchases ->
                _purchaseHistory.value = purchases
            }
        }
    }

    fun getPizzas(): List<Pizza> {
        return pizzaList
    }

    fun getPizzaById(id: Int): Pizza? {
        return pizzaList.find { it.id == id }
    }

    fun addPizzaToCart(pizza: Pizza, extraCheese: Int) {
        _cartItems.value = _cartItems.value + pizza
        _totalPrice.value += pizza.price + extraCheese
    }

    fun validateOrder() {
        viewModelScope.launch {
            val purchase = Purchase(
                date = System.currentTimeMillis(),
                total = _totalPrice.value,
                items = Gson().toJson(_cartItems.value)
            )
            purchaseDao.insertPurchase(purchase)
            _cartItems.value = emptyList()
            _totalPrice.value = 0.0
        }
    }

    class Factory(private val purchaseDao: PurchaseDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PizzaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PizzaViewModel(purchaseDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}