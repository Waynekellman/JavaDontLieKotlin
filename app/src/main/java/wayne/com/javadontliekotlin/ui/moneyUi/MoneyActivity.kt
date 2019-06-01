package wayne.com.javadontliekotlin.ui.moneyUi

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_money.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.data.db.Game
import android.content.Intent
import android.view.MenuItem
import wayne.com.javadontliekotlin.ui.startUi.StartActivity


class MoneyActivity : AppCompatActivity() , KodeinAware {
    override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }
    private val viewModelFactory: MoneyViewModelFactory by instance()

    private val viewModel: MoneyViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MoneyViewModel::class.java)
    }

    private val adapter: MoneyAdapter =
        MoneyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        val gameId = intent.getLongExtra("gameId", -1)
        viewModel.getGame(gameId) { game -> setList(game)}


        money_rec.layoutManager = LinearLayoutManager(this)
        money_rec.adapter = adapter

        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun calculateMoney(v: View) {
        if (money_amount_text.text.isEmpty()) return
        if (v.tag == resources.getString(R.string.plus)) {
            viewModel.calculate(money_amount_text.text.toString().toDouble().unaryPlus())
            clear(v)
        } else {
            viewModel.calculate(money_amount_text.text.toString().toDouble().unaryMinus())
            clear(v)
        }
    }

    private fun setList(game: Game) {
        title = game.gameName
        val amount = "%.2f".format(game.amount)
        money_amount.text = amount
        adapter.setList(game.log)
    }

    fun toText(v: View){
        if (money_amount_text.text.length > 3 && money_amount_text.text[money_amount_text.text.length - 3] == '.') return
        val text = v as Button
        if (money_amount_text.text.isBlank() && text.tag == "decimalpoint") money_amount_text.append("0.")
        else if (money_amount_text.text.isNotBlank() && text.tag == "decimalpoint") {
            money_amount_text.append(".")
        }
        else money_amount_text.append(text.text)
    }

    @Suppress("UNUSED_PARAMETER")
    fun clear(v: View){
        money_amount_text.text = ""
    }

    @Suppress("UNUSED_PARAMETER")
    fun deleteText(v: View){
        if (money_amount_text.text.startsWith("0.") && money_amount_text.text.length == 2) money_amount_text.text = ""
        if (money_amount_text.text.isNotBlank()) money_amount_text.text = money_amount_text.text.substring(0, money_amount_text.text.length - 1)

    }

    @Suppress("UNUSED_PARAMETER")
    fun hide(v: View){
        if (money_rec.isVisible){
            hide.visibility = View.VISIBLE
            hide_rec.visibility = View.GONE
            money_rec.visibility = View.GONE
        } else {
            hide.visibility = View.GONE
            hide_rec.visibility= View.VISIBLE
            money_rec.visibility = View.VISIBLE
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(this, StartActivity::class.java)
        startActivity(myIntent)
        return true
    }
}
