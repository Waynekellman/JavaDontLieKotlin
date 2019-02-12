package wayne.com.javadontliekotlin

import androidx.lifecycle.LiveData


class GameRepository(gamesDataBase: GamesDataBase) {

    var gamesDao: GamesDao = gamesDataBase.gamesDao()
    val games: LiveData<List<Game>> = gamesDao.getAll()

    fun insert(game: Game) {
//        doAsync { gamesDao.insert(game) }
    }

    fun update(game: Game) {
//        doAsync { gamesDao.update(game) }
    }

    fun delete(game: Game) {
//        doAsync { gamesDao.delete(game) }
    }

    fun deleteAllGames() {
//        doAsync { gamesDao.deleteAllGames() }
    }



}