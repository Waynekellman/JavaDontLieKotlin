package wayne.com.javadontliekotlin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import wayne.com.javadontliekotlin.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title_main.text = "Java Don't Lie"
        start_main.setOnClickListener {
            val startActivity=Intent(this, StartActivity::class.java)
            startActivity(startActivity)
        }



    }
}
