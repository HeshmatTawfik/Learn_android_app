package com.heshmat.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.heshmat.learnandroid.models.Topic;
import com.heshmat.learnandroid.userui.QuizActivity;

public class TopicActivity extends AppCompatActivity {
    @BindView(R.id.topicTitleTv)
    TextView title;
    @BindView(R.id.topicContentTv)
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);
        title.setText(Topic.currentChosenTopic.getTitle());
        content.setText(Topic.currentChosenTopic.getContent());
    }
    @OnClick(R.id.exerciseBt)
    public void  doQuiz(View view){
        startActivity(new Intent(this, QuizActivity.class));
    }
}
