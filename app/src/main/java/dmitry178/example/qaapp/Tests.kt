package dmitry178.example.qaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Tests : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests)
    }

    fun startTest1(view: View) {
        val intentProfile = Intent(this, TestFirst::class.java)
        startActivity(intentProfile)
        finish()
    }

    fun startTest2(view: View) {
        val intentProfile = Intent(this, TestSecond::class.java)
        startActivity(intentProfile)
        finish()
    }

    fun startTest3(view: View) {
        val intentProfile = Intent(this, TestThird::class.java)
        startActivity(intentProfile)
        finish()
    }

    fun startTest4(view: View) {
        val intentProfile = Intent(this, TestFourth::class.java)
        startActivity(intentProfile)
        finish()
    }

    fun backMain(view: View) {
        val intentProfile = Intent(this, MainActivity::class.java)
        startActivity(intentProfile)
        finish()
    }
}