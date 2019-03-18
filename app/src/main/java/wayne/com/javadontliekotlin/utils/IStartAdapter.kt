package wayne.com.javadontliekotlin.utils

import wayne.com.javadontliekotlin.data.db.Game

interface IAdapter {
    fun swapItems(fromPosition: Int, toPosition: Int)
    fun getGamesAt(position: Int): Game
}