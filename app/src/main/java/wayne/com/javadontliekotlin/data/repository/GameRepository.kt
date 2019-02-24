package wayne.com.javadontliekotlin.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.data.db.GamesDao


@Suppress("NAME_SHADOWING")
class GameRepository(private val gamesDao: GamesDao): IGameRepository {

    @SuppressLint("CheckResult")
    override fun getGame(id: Long, callback: (Game) -> Unit) {
        gamesDao.getGameById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { game -> callback(game)}

    }

    private val disposables = CompositeDisposable()

    override fun insert(game: Game) {
        disposables.add(gamesDao.insert(game)
            .subscribeOn(Schedulers.io())
            .subscribe())
    }

    override fun delete(game: Game) {
        disposables.add(gamesDao.delete(game)
            .subscribeOn(Schedulers.io())
            .subscribe())
    }

    override fun deleteAllGames() {
       disposables.add(Observable.fromCallable { gamesDao.deleteAllGames() }
            .subscribeOn(Schedulers.io())
            .subscribe())
    }
    override fun getAllGames(): LiveData<List<Game>> {
        return gamesDao.getAll()
    }



}