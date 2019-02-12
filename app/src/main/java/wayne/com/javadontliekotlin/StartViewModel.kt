package wayne.com.javadontliekotlin

import javax.inject.Inject


class StartViewModel @Inject constructor(private val repository: GameRepository) {

    var allGames = repository.games

    fun insert(game: Game) {
        repository.insert(game)
    }
    fun delete(game: Game) {
        repository.delete(game)
    }
    fun update(game: Game) {
        repository.update(game)
    }
    fun deleteAllGames(){
        repository.deleteAllGames()
    }

    fun setupGame(game: Game){

    }


}