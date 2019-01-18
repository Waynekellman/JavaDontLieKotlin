package wayne.com.javadontliekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

class StartActivity : AppCompatActivity() {

    @Inject lateinit var gamesDataBase: GamesDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        new_game.setOnClickListener {
            if (new_game_name.text.isNotEmpty() && money_amount_start.text.isNotEmpty()){

                Observable.fromCallable{
                    var game = Game()
                    game.gameName = new_game_name.text.toString()
                    game.amount = money_amount_start.text.toString().toInt()
                    gamesDataBase.gamesDao().insert(game)
                }.subscribeOn(Schedulers.io())
                    .subscribe()

            }
        }

    }
}
