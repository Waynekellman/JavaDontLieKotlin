package wayne.com.javadontliekotlin

import android.app.Application

class JavaDontLieApp : Application() {

    val component: GameComponent by lazy {
        DaggerGameComponent
            .builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}