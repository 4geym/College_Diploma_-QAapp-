package dmitry178.example.qaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView uScore = (TextView) findViewById(R.id.uScore);
        TextView uHighScore = (TextView) findViewById(R.id.uHighScore);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        uScore.setText("Your score: " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if (highscore >= score)
            uHighScore.setText("High score: " + highscore);
        else {
            uHighScore.setText("New highscore: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(ScoreActivity.this, TestFirst.class);
        startActivity(intent);
    }

    public void onClickExit(View view) {
        Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void backMain(View view) {
        Intent intent = new Intent(ScoreActivity.this, Tests.class);
        startActivity(intent);
    }
}