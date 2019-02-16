package wayne.com.javadontliekotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_start.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.data.db.Game

class StartActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }
    private val viewModelFactory: StartViewModelFactory by instance()
    private val viewModel: StartViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(StartViewModel::class.java)
    }
    private val adapter:GameAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initializeUI()
        new_game.setOnClickListener {
            if (new_game_name.text.isNotEmpty() && money_amount_start.text.isNotEmpty()) {
                val game = Game()
                game.amount = money_amount_start.text.toString().toInt()
                game.gameName = new_game_name.text.toString()
                viewModel.insert(game)
            }
        }
    }

    private fun initializeUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllGames().observe(this, Observer {gamesList ->
            adapter.setList(gamesList)
        })
    }
}
