package wayne.com.javadontliekotlin

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = arrayOf(Game::class), version = 1, exportSchema = false)
@TypeConverters(GsonTypeConverter::class)
abstract class GamesDataBase : RoomDatabase() {
    abstract fun gamesDao() :GamesDao


}