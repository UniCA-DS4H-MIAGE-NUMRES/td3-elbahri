package Numres.ELBAHRI.pizzaapp.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "pizza_app_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
