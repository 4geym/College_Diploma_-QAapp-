package dmitry178.example.qaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestFirst extends AppCompatActivity {

    private Questions mQuestions = new Questions();

    private Button button1, button2, button3, button4;

    private TextView score, textView2;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_first);

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
        if (mQuestionNumber < mQuestions.getLength()) {
            textView2.setText(mQuestions.getQuestion(mQuestionNumber));
            button1.setText(mQuestions.getChoice(mQuestionNumber, 1));
            button2.setText(mQuestions.getChoice(mQuestionNumber, 2));
            button3.setText(mQuestions.getChoice(mQuestionNumber, 3));
            button4.setText(mQuestions.getChoice(mQuestionNumber, 4));

            mAnswer = mQuestions.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(TestFirst.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TestFirst.this, ScoreActivity.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        score.setText("" + mScore + "/" + mQuestions.getLength());
    }

    public void onClick(View view) {
        Button answer = (Button) view;
        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            Toast.makeText(TestFirst.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(TestFirst.this, "Wrong!", Toast.LENGTH_SHORT).show();
            updateScore(mScore);
            updateQuestion();
    }

    public void backMain(View view) {
        Intent intent = new Intent(TestFirst.this, Tests.class);
        startActivity(intent);
    }
}