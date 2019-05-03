package wayne.com.javadontliekotlin.ui.moneyUi

import androidx.lifecycle.ViewModel
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.repository.IGameRepository

class MoneyViewModel constructor(private val repository: IGameRepository): ViewModel() {

    var currentGame = Game()

    fun getGame(id: Long, callback: (Game) -> Unit) {
        repository.getGame(id) { game ->
            currentGame = game
            callback(currentGame)
        }
    }

    fun delete(game: Game) = repository.delete(game)
    fun update(game: Game) = repository.insert(game)

    fun calculate(amount: Double) {
        currentGame.amount += amount
        val newAmount = "%.2f".format(amount).toDouble()
        if (amount < 0) {
            val newAmountNegative = newAmount * -1
            currentGame.log.add("Paid: $newAmountNegative")
        } else {
            currentGame.log.add("Received: $newAmount")
        }
        update(currentGame)
    }

}