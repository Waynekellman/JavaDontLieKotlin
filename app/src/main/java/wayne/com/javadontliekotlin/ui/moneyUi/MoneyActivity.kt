package wayne.com.javadontliekotlin.ui.moneyUi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_money.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R

//TODO create keyboard for numbers
//TODO create log screen

class MoneyActivity : AppCompatActivity() , KodeinAware {
    override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }
    private val viewModelFactory: MoneyViewModelFactory by instance()
    private val viewModel: MoneyViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MoneyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)

        val gameId = intent.getLongExtra("gameId", -1)
        viewModel.getGame(gameId) { game -> money_amount.text = game.amount.toString() }

        //TODO: have Add and subtract buttons
        addition.setOnClickListener {
            if (amount_text.text.isNotEmpty()) {
                viewModel.calculate(amount_text.text.toString().toLong().unaryPlus())
                updateUI()
            }
        }
        subtract.setOnClickListener {
            if (amount_text.text.isNotEmpty()) {
                viewModel.calculate(amount_text.text.toString().toLong().unaryMinus())
                updateUI()
            }
        }


    }

    private fun updateUI() {
        money_amount.text = viewModel.currentGame.amount.toString()
    }
}
