package wayne.com.javadontliekotlin.data.repository

import androidx.lifecycle.LiveData
import wayne.com.javadontliekotlin.data.db.Game

interface IGameRepository {
    fun insert(game: Game)
    fun update(game: Game)
    fun delete(game: Game)
    fun deleteAllGames()
    fun getAllGames(): LiveData<List<Game>>
    fun getGame(id: Long, callback: (Game) -> Unit)
}