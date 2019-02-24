package wayne.com.javadontliekotlin.ui.startUi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_item.view.*
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.ui.moneyUi.MoneyActivity
import wayne.com.javadontliekotlin.utils.IAdapter

class StartAdapter: RecyclerView.Adapter<StartAdapter.GameViewHolder>(), IAdapter {

    private val games = ArrayList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.name?.text = games[position].gameName
        holder.amount?.text = games[position].amount.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MoneyActivity::class.java)
            intent.putExtra("gameId", games[position].id)
            holder.itemView.context.startActivity(intent)

        }

    }


    override fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                games[i] = games.set(i+1, games[i])
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                games[i] = games.set(i-1, games[i])
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    override fun getGamesAt(position: Int): Game {
        return games[position]
    }

    fun setList(gamesList: List<Game>) {
        //TODO Optimize notifying the ui of list changes
        games.clear()
        games.addAll(gamesList)
        notifyDataSetChanged()
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.game_name
        val amount = itemView.game_amount
    }

}