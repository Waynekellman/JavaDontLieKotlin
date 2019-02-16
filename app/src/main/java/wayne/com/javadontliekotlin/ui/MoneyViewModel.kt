package wayne.com.javadontliekotlin.ui

import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import wayne.com.javadontliekotlin.utils.SetupGame
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.repository.GameRepository

class MoneyViewModel constructor(private val repository: GameRepository): Consumer<SetupGame>, ObservableSource<StartViewModel> {


    override fun accept(t: SetupGame?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribe(observer: Observer<in StartViewModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var currentGame: Game = Game()

    fun update(game: Game) {
        repository.update(game)
    }
    fun delete(game: Game) {
        repository.delete(game)
    }
}