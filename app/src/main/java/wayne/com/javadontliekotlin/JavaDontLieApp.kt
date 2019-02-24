package wayne.com.javadontliekotlin

import android.app.Application
import androidx.room.Room
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import wayne.com.javadontliekotlin.data.db.GamesDao
import wayne.com.javadontliekotlin.data.db.GamesDataBase
import wayne.com.javadontliekotlin.data.db.IGamesDatabase
import wayne.com.javadontliekotlin.data.repository.GameRepository
import wayne.com.javadontliekotlin.data.repository.IGameRepository
import wayne.com.javadontliekotlin.ui.moneyUi.MoneyViewModelFactory
import wayne.com.javadontliekotlin.ui.startUi.StartViewModel
import wayne.com.javadontliekotlin.ui.startUi.StartViewModelFactory


@Suppress("unused")
class JavaDontLieApp : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind<IGamesDatabase>() with singleton {
            Room.databaseBuilder(this@JavaDontLieApp, GamesDataBase::class.java,"GamesDataBase")
                .fallbackToDestructiveMigration()
                .build()
        }
        bind<GamesDao>() with singleton { instance<IGamesDatabase>().gamesDao() }
        bind<IGameRepository>() with singleton { GameRepository(instance()) }
        bind() from provider { StartViewModelFactory(instance()) }
        bind() from provider { MoneyViewModelFactory(instance()) }
    }
}