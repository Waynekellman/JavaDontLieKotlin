package wayne.com.javadontliekotlin

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GameModule(private val app: Application) {

    @Provides @Singleton fun provideAppContext(): Context {
        return app
    }

    @Provides @Singleton fun provideGameDatabase(app: Context) : GamesDataBase {
        return Room.databaseBuilder(
            app,
            GamesDataBase::class.java,
            "GameDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides @Singleton fun provideRespository(gamesDataBase: GamesDataBase) :GameRepository {
        return GameRepository(gamesDataBase)
    }
}