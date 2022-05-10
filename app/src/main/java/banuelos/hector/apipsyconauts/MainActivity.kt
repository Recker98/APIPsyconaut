package banuelos.hector.apipsyconauts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val psypowers = listOf<>(
        psyconauts("Allows the user to see through the minds of others."),
        psyconauts("Allows the user to confuse enemies."),
        psyconauts("Allows the user to turn invisible for a short period of time."),
        psyconauts("Allows the user to levitate using a levitation ball."),
        psyconauts("Allows the user to strike things down using their mind."),
        psyconauts("Allows the user to break objects using their mind."),
        psyconauts("Allows the user to set objects on fire using their mind."),
        psyconauts("Allows the user to create a psychic shield."),
        psyconauts("Allows the user to move objects with their mind.")


        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}