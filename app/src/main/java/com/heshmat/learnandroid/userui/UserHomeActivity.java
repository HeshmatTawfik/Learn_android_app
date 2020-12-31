package com.heshmat.learnandroid.userui;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.heshmat.learnandroid.LoginActivity;
import com.heshmat.learnandroid.R;
import com.heshmat.learnandroid.models.User;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.logout)
    public void lotoutBt(View view) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong("id", -1).apply();
        User.currentUser=null;
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
