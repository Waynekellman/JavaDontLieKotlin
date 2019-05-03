package wayne.com.javadontliekotlin.ui.startUi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_item.view.*
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.data.db.Game
import wayne.com.javadontliekotlin.ui.moneyUi.MoneyActivity
import wayne.com.javadontliekotlin.utils.IStartAdapter

class StartStartAdapter: RecyclerView.Adapter<StartStartAdapter.GameViewHolder>(), IStartAdapter {

    private val games = ArrayList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.name.text = games[position].gameName
        val amount = "%.2f".format(games[position].amount)
        holder.amount.text = amount
        setTextColor(position, holder)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MoneyActivity::class.java)
            intent.putExtra("gameId", games[position].id)
            holder.itemView.context.startActivity(intent)

        }

    }

    private fun setTextColor(
        position: Int,
        holder: GameViewHolder
    ) {
        when {
            games[position].amount < 0 -> holder.amount.setTextColor(ContextCompat.getColor(holder.amount.context, R.color.red))
            games[position].amount > 0 -> holder.amount.setTextColor(ContextCompat.getColor(holder.amount.context, R.color.green))
            else -> holder.amount.setTextColor(ContextCompat.getColor(holder.amount.context, R.color.black))
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

    override fun setList(gamesList: List<Game>) {
        games.clear()
        games.addAll(gamesList)
        notifyDataSetChanged()
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.game_name
        val amount: TextView = itemView.game_amount
    }

}