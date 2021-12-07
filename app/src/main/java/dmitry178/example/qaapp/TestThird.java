package dmitry178.example.qaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestThird extends AppCompatActivity {

    private Questions3 mQuestion = new Questions3();

    private Button button1, button2, button3, button4;

    private TextView score, textView2;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_third);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        score = (TextView) findViewById(R.id.score);
        textView2 = (TextView) findViewById(R.id.textView2);

        updateQuestion();
        updateScore(mScore);
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestion.getLength3()) {
            textView2.setText(mQuestion.getQuestion3(mQuestionNumber));
            button1.setText(mQuestion.getChoice3(mQuestionNumber, 1));
            button2.setText(mQuestion.getChoice3(mQuestionNumber, 2));
            button3.setText(mQuestion.getChoice3(mQuestionNumber, 3));
            button4.setText(mQuestion.getChoice3(mQuestionNumber, 4));

            mAnswer = mQuestion.getCorrectAnswer3(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(TestThird.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TestThird.this, ScoreActivity3.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        score.setText("" + mScore + "/" + mQuestion.getLength3());
    }

    public void onClick(View view) {
        Button answer = (Button) view;
        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            Toast.makeText(TestThird.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(TestThird.this, "Wrong!", Toast.LENGTH_SHORT).show();
        updateScore(mScore);
        updateQuestion();
    }

    public void backMain(View view) {
        Intent intent = new Intent(TestThird.this, Tests.class);
        startActivity(intent);
    }
}