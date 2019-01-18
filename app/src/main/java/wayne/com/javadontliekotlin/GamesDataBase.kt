package wayne.com.javadontliekotlin

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = arrayOf(Game::class), version = 1, exportSchema = false)
@TypeConverters(GsonTypeConverter::class)
abstract class GamesDataBase : RoomDatabase() {
    abstract fun gamesDao() :GamesDao
}