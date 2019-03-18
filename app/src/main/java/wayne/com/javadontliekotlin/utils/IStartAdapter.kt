package wayne.com.javadontliekotlin.utils

import wayne.com.javadontliekotlin.data.db.Game

interface IStartAdapter {
    fun swapItems(fromPosition: Int, toPosition: Int)
    fun getGamesAt(position: Int): Game
    fun setList(gamesList: List<Game>)
}