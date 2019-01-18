package wayne.com.javadontliekotlin

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GameModule::class])
interface GameComponent {
    fun inject(app: JavaDontLieApp)
}