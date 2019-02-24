package wayne.com.javadontliekotlin.ui.startUi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_start.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R
import wayne.com.javadontliekotlin.ui.moneyUi.MoneyActivity
import wayne.com.javadontliekotlin.utils.DragManageAdapter

class StartActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }
    private val viewModelFactory: StartViewModelFactory by instance()
    private val viewModel: StartViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(StartViewModel::class.java)
    }
    private val adapter: StartAdapter =
        StartAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initializeUI()
        new_game.setOnClickListener {
            if (new_game_name.text.isNotEmpty() && money_amount_start.text.isNotEmpty()) {
                viewModel.createNewGame(new_game_name.text.toString(), money_amount_start.text.toString().toInt())
            }
        }
    }

    private fun initializeUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllGames().observe(this, Observer {gamesList ->
            if (viewModel.newGame) {
                viewModel.newGame = false
                val intent = Intent(this,MoneyActivity::class.java)
                intent.putExtra("gameId", gamesList.first().id)
                startActivity(intent)
            }
            adapter.setList(gamesList)
        })

        val callback = DragManageAdapter(adapter, this, 0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT), viewModel)
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_start, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.start_menu -> {
                deleteAllGames()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAllGames() {
        let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.are_you_sure)
            builder.apply {
                setPositiveButton(R.string.ok
                ) { _, _ ->
                    viewModel.deleteAllGames()
                }
                setNegativeButton(R.string.no
                ) { _, _ ->
                    // User cancelled the dialog
                }
            }
            builder.create()
        }.show()


    }


}
