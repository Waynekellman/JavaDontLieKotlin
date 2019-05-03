package wayne.com.javadontliekotlin.ui.moneyUi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_money.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R

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
        viewModel.getGame(gameId) { game ->
            val amount = "%.2f".format(game.amount)
            money_amount.text = amount
            adapter.setList(game.log)
        }
        addition.setOnClickListener {
            if (money_amount_text.text.isNotEmpty()) {
                viewModel.calculate(money_amount_text.text.toString().toDouble().unaryPlus())
            }
        }
        subtract.setOnClickListener {
            if (money_amount_text.text.isNotEmpty()) {
                viewModel.calculate(money_amount_text.text.toString().toDouble().unaryMinus())
            }
        }


        money_rec.layoutManager = LinearLayoutManager(this)
        money_rec.adapter = adapter


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

    fun clear(v: View){
        money_amount_text.text = ""
    }

    fun deleteText(v: View){
        if (money_amount_text.text.startsWith("0.") && money_amount_text.text.length == 2) money_amount_text.text = ""
        if (money_amount_text.text.isNotBlank()) money_amount_text.text = money_amount_text.text.substring(0, money_amount_text.text.length - 1)

    }
}
