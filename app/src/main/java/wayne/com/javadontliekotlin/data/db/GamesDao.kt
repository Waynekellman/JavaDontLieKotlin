package wayne.com.javadontliekotlin.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable


@Dao
interface GamesDao {

    @Query("SELECT * from Games ORDER BY id DESC")
    fun getAll() : LiveData<List<Game>>

    @Query("SELECT * from Games WHERE id IN (:id)")
    fun getGameById(id: Long) : Flowable<Game>

    @Insert(onConflict = REPLACE)
    fun insert(game: Game) : Completable

    @Delete
    fun delete(game: Game) : Completable

    @Query("DELETE FROM Games")
    fun deleteAllGames()

}