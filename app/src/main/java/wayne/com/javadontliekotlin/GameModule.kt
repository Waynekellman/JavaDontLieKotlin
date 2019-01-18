package wayne.com.javadontliekotlin

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GameModule(val app: JavaDontLieApp) {

    private val DATABASE_NAME = "GamesDataBase"

    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton fun provideDatabase(app: JavaDontLieApp): GamesDataBase {
        return Room.databaseBuilder(
            app,
            GamesDataBase::class.java, DATABASE_NAME
        ).build()
    }
}