package wayne.com.javadontliekotlin.data.db

interface IGamesDatabase {
    fun gamesDao() : GamesDao
}