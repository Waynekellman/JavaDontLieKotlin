package wayne.com.javadontliekotlin

import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MoneyViewModel @Inject constructor(private val repository: GameRepository): Consumer<SetupGame>, ObservableSource<StartViewModel> {

    @Inject lateinit var startViewModel: StartViewModel

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