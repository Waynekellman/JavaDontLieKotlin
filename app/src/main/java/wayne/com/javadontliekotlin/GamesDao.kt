package wayne.com.javadontliekotlin

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface GamesDao {

    @Query("SELECT * from Games")
    fun getAll() : List<Game>

    @Insert(onConflict = REPLACE)
    fun insert(game: Game)

    @Delete
    fun delete(game: Game)

}