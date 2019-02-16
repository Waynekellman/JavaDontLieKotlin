package wayne.com.javadontliekotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import wayne.com.javadontliekotlin.R

class StartActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }
    private val viewModelFactory: StartViewModelFactory by instance()
    private val viewModel: StartViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(StartViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initializeUI()
    }

    private fun initializeUI() {

        viewModel.getAllGames().observe(this, Observer {gamesList ->
            //initialize RV
        })
    }
}
