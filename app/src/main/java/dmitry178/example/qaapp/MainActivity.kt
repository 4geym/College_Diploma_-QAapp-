package dmitry178.example.qaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startProfile(view: View) {
        val intentProfile = Intent(this, Profile::class.java)
        startActivity(intentProfile)
    }

    fun startTests(view: View) {
        val intentTests = Intent(this, Tests::class.java)
        startActivity(intentTests)
    }

}