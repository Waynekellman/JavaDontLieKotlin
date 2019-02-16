package wayne.com.javadontliekotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_item.view.*
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.data.db.Game

class GameAdapter: RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private val games = ArrayList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder?.name?.text = games.get(position).gameName
        holder?.amount?.text = games.get(position).amount.toString()
    }

    fun setList(gamesList: List<Game>) {
        games.clear()
        games.addAll(gamesList)
        notifyDataSetChanged()
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.game_name
        val amount = itemView.game_amount
    }

}