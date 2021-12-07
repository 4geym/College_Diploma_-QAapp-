package dmitry178.example.qaapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        loadData()

        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            saveData()
        }
    }
    private fun saveData() {
        val personName = findViewById<EditText>(R.id.personName)
        val nameSave = findViewById<TextView>(R.id.nameSave)
        val check = findViewById<CheckBox>(R.id.check)


        val insertedText = personName.text.toString()
        nameSave.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", check.isChecked)
        }.apply()

        Toast.makeText(this,"Data saved!", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val nameSave = findViewById<TextView>(R.id.nameSave)
        val check = findViewById<CheckBox>(R.id.check)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        nameSave.text = savedString
        check.isChecked = savedBoolean
    }

    fun startScore1(view: View) {
        val intentProfile = Intent(this, ScoreActivity::class.java)
        startActivity(intentProfile)
    }

    fun startScore2(view: View) {
        val intentProfile = Intent(this, ScoreActivity2::class.java)
        startActivity(intentProfile)
    }

    fun startScore3(view: View) {
        val intentProfile = Intent(this, ScoreActivity3::class.java)
        startActivity(intentProfile)
    }

    fun startScore4(view: View) {
        val intentProfile = Intent(this, ScoreActivity4::class.java)
        startActivity(intentProfile)
    }

    fun backMain(view: View) {
        val intentTests = Intent(this, MainActivity::class.java)
        startActivity(intentTests)
        finish()
    }
}