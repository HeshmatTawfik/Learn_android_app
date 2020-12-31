package com.heshmat.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.OnClick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.heshmat.learnandroid.adminui.AdminHomeActivity;
import com.heshmat.learnandroid.models.Question;
import com.heshmat.learnandroid.models.Topic;
import com.heshmat.learnandroid.models.User;
import com.heshmat.learnandroid.userui.UserHomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter mDatabaseAdapter;
    private final static String TAG="MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseAdapter = DatabaseAdapter.getDatabaseAdapter(this);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        boolean topicWasInserted  = sharedPreferences.getBoolean("wasInserted", false);
        if (!topicWasInserted){
            for(Topic topic:TopicsCreate.topics()){
                mDatabaseAdapter.insertTopic(topic);

            }
            sharedPreferences.edit().putBoolean("wasInserted", true).apply();

        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectUser();

            }
        }, 3000);

    }

    private void redirectUser() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        long id = sharedPreferences.getLong("id", -1);
        if (id != -1) {
            User.currentUser = mDatabaseAdapter.getUserById(id);
            if (User.currentUser != null) {
                if (User.currentUser.getRole() == StaticFields.ROLE_ADMIN) {
                    startActivity(AdminHomeActivity.class);
                } else if (User.currentUser.getRole() == StaticFields.ROLE_USER) {
                    startActivity(UserHomeActivity.class);

                } else {
                    startActivity(LoginActivity.class);

                }
            }


        } else {
            startActivity(LoginActivity.class);


        }

    }


    private void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }
}
