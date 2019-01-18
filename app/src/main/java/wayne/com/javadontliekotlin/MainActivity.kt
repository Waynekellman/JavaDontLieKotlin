package wayne.com.javadontliekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title_main.text = "Java Don't Lie"
        start_main.setOnClickListener {
            val startActivity=Intent(this,StartActivity::class.java)
            startActivity(startActivity)
        }



    }
}
