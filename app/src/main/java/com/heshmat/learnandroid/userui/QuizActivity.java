package com.heshmat.learnandroid.userui;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.heshmat.learnandroid.DatabaseAdapter;
import com.heshmat.learnandroid.R;
import com.heshmat.learnandroid.models.Question;
import com.heshmat.learnandroid.models.Topic;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG ="QuizActivity" ;
    @BindView(R.id.questionTv)
    TextView questionTv;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.radioButton)
    RadioButton radioButton1;
    @BindView(R.id.radioButton2)
    RadioButton radioButton2;
    @BindView(R.id.radioButton3)
    RadioButton radioButton3;
    @BindView(R.id.radioButton4)
    RadioButton radioButton4;
    @BindView(R.id.scoreTv)
    TextView scoreTv;
    @BindView(R.id.totalQuestionsTv)
    TextView totalQuestionsTv;
    int score;
    int totalQuestions;
    int answeredQuestions;
    List<Question> questions;
    DatabaseAdapter mDatabaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        questions = Topic.currentChosenTopic.getExercise();
        totalQuestions = questions.size();
        answeredQuestions = 0;
        initQuestion(questions.get(answeredQuestions));
        scoreTv.setText("Score:" + score);
        totalQuestionsTv.setText(0 + "/" + totalQuestions);
        mDatabaseAdapter = DatabaseAdapter.getDatabaseAdapter(this);


    }

    @OnClick(R.id.submit)
    public void submitQuestion(View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton selected = findViewById(id);
        if (answeredQuestions + 1 < questions.size()) {

            if (id != -1) {
                if (selected.getText().toString().equals(questions.get(answeredQuestions).getCorrectChoice())) { //check for correct answer
                    score += 1;
                    scoreTv.setText("Score:" + score);


                }
                answeredQuestions += 1;
                totalQuestionsTv.setText(answeredQuestions + "/" + totalQuestions);
            }

            radioGroup.clearCheck();
            initQuestion(questions.get(answeredQuestions));


        } else {

            if (selected.getText().toString().equals(questions.get(questions.size()-1).getCorrectChoice())) { //check for correct answer
                score += 1;
                scoreTv.setText("Score:" + score);
            }
            totalQuestionsTv.setText(answeredQuestions+1 + "/" + totalQuestions);

            new AlertDialog.Builder(this).setMessage("Your score is " + score + " out of " + totalQuestions + " Would like to to do the quiz once again ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            answeredQuestions = 0;
                            initQuestion(questions.get(answeredQuestions));
                            score=0;
                            scoreTv.setText("Score:" + score);
                            totalQuestionsTv.setText(0 + "/" + totalQuestions);
                            radioGroup.clearCheck();



                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mDatabaseAdapter.updateTopic(Topic.currentChosenTopic);
                    Intent intent = new Intent(QuizActivity.this, UserHomeActivity.class);
                    startActivity(intent);
                    finish();


                }
            }).setCancelable(false).show();

        }


    }

    public void initQuestion(Question question) {
        try {

            String[] arr = question.answerArr();
            questionTv.setText(question.getQuestion());

            radioButton1.setText(arr[0]);
            radioButton2.setText(arr[1]);
            radioButton3.setText(arr[2]);
            radioButton4.setText(arr[3]);
        } catch (Exception e) {
            Log.i(TAG, "initQuestion: "+e.toString());

        }


    }
}
