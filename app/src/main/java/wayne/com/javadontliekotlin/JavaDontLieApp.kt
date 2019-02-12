package wayne.com.javadontliekotlin

import android.app.Application

class JavaDontLieApp : Application() {

    lateinit var component: GameComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerGameComponent.builder().gameModule(GameModule(this)).build()
    }
}