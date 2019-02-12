package wayne.com.javadontliekotlin

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface GamesDao {

    @Query("SELECT * from Games ORDER BY id DESC")
    fun getAll() : LiveData<List<Game>>

    @Query("SELECT * from Games WHERE id IN (:id)")
    fun getGameById(id: Int) : Game

    @Insert(onConflict = REPLACE)
    fun insert(game: Game) : Long

    @Update
    fun update(game: Game)

    @Delete
    fun delete(game: Game)

    @Query("DELETE FROM Games")
    fun deleteAllGames()

}