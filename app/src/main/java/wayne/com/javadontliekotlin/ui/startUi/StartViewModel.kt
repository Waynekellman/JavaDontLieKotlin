package wayne.com.javadontliekotlin.ui.startUi

import androidx.lifecycle.ViewModel
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.repository.IGameRepository


class StartViewModel(private val repository: IGameRepository) : ViewModel() {

    var newGame: Boolean = false

    private fun insert(game: Game) = repository.insert(game)

    fun delete(game: Game) = repository.delete(game)

    fun deleteAllGames() = repository.deleteAllGames()

    fun getAllGames() = repository.getAllGames()

    fun createNewGame(gameName: String, amount: Double, logStart: ArrayList<String> = ArrayList()) {
        if (amount != 0.0) logStart.add("Start: $amount")
        insert(Game(gameName = gameName, amount = amount, log = logStart))
        newGame = true
    }


}