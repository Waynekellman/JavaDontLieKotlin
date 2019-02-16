package wayne.com.javadontliekotlin.data.repository

import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.db.GamesDao


class GameRepository(private val gamesDao: GamesDao): IGameRepository {

    private val disposables = CompositeDisposable()

    override fun insert(game: Game) {
        disposables.add(Observable.just(game)
            .subscribeOn(Schedulers.io())
            .subscribe { game -> gamesDao.insert(game) })
    }

    override fun update(game: Game) {
        disposables.add(Observable.just(game)
            .subscribeOn(Schedulers.io())
            .subscribe { game -> gamesDao.update(game) })
    }

    override fun delete(game: Game) {
        disposables.add(Observable.just(game)
            .subscribeOn(Schedulers.io())
            .subscribe { game -> gamesDao.delete(game) })
    }

    override fun deleteAllGames() {
        disposables.add(Observable.just(gamesDao)
            .subscribeOn(Schedulers.io())
            .subscribe {  gamesDao.deleteAllGames() })
    }
    override fun getAllGames(): LiveData<List<Game>> {
        return gamesDao.getAll()
    }



}