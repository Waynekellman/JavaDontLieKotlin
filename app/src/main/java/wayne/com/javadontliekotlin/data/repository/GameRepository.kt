package wayne.com.javadontliekotlin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.db.GamesDao


class GameRepository(private val gamesDao: GamesDao): IGameRepository {


    private val games = MutableLiveData<List<Game>>()

    override fun insert(game: Game) {
//        doAsync { gamesDao.insert(game) }
    }

    override fun update(game: Game) {
//        doAsync { gamesDao.update(game) }
    }

    override fun delete(game: Game) {
//        doAsync { gamesDao.delete(game) }
    }

    override fun deleteAllGames() {
//        doAsync { gamesDao.deleteAllGames() }
    }
    override fun getAllGames(): LiveData<List<Game>> {
        return gamesDao.getAll()
    }



}