package wayne.com.javadontliekotlin.ui

import androidx.lifecycle.ViewModel
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.repository.IGameRepository


class StartViewModel(private val repository: IGameRepository) : ViewModel() {

    fun insert(game: Game) = repository.insert(game)

    fun delete(game: Game) = repository.delete(game)

    fun update(game: Game) = repository.update(game)

    fun deleteAllGames()= repository.deleteAllGames()

    fun getAllGames() = repository.getAllGames()


}