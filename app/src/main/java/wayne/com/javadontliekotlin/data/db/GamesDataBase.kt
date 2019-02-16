package wayne.com.javadontliekotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import wayne.com.javadontliekotlin.utils.GsonTypeConverter


@Database(entities = arrayOf(Game::class), version = 1, exportSchema = false)
@TypeConverters(GsonTypeConverter::class)
abstract class GamesDataBase : RoomDatabase(), IGamesDatabase {
    abstract override fun gamesDao() : GamesDao


}