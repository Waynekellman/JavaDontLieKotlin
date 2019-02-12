package wayne.com.javadontliekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

class StartActivity : AppCompatActivity() {

    @Inject lateinit var startViewModel: StartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        component.inject(this)

        new_game.setOnClickListener {
            if (new_game_name.text.isNotEmpty() && money_amount_start.text.isNotEmpty()) {

                val game = Game()
                game.gameName = new_game_name.text.toString()
                game.amount = money_amount_start.text.toString().toInt()
                startViewModel.insert(game)

            }
        }
    }
}
