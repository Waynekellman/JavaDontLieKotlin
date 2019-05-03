package wayne.com.javadontliekotlin.ui.moneyUi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.money_item.view.*
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.utils.IMoneyAdapter

class MoneyAdapter: RecyclerView.Adapter<MoneyAdapter.MoneyViewHolder>(), IMoneyAdapter {

    //TODO: Make payments log list smaller in UI as the list goes down. Show top (most recent) payment as biggest
    private val logArray = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder {
        return MoneyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.money_item, parent, false))
    }

    override fun getItemCount(): Int {
        return logArray.size
    }

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {
        holder.log.text = logArray[position]
    }

    override fun setList(log: ArrayList<String>) {
        logArray.clear()
        log.reverse()
        logArray.addAll(log)
        notifyDataSetChanged()
    }

    inner class MoneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val log: TextView = itemView.money_log
    }
}