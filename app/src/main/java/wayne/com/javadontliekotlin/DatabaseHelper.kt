package wayne.com.javadontliekotlin

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class DatabaseHelper(private val gamesDao: GamesDao): CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext = job + Main

    fun saveGame(game: Game, function: (id: Long) -> (Unit)) = runBlocking {
        launch {
            try {
                val id = gamesDao.insert(game)
                if(id <= 0) {
                    function(0)
                } else function(id)
            } catch (e: Exception) {
                //TODO: make an exception call
                Log.d("Databasehelper",e.message)
            }
        }

    }
}