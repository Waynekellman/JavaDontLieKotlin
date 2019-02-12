package wayne.com.javadontliekotlin

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.component() : GameComponent = (application as JavaDontLieApp).component

val AppCompatActivity.component : GameComponent
    get() = (application as JavaDontLieApp).component