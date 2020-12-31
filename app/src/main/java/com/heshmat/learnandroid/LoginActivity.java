package com.heshmat.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.heshmat.learnandroid.adminui.AdminHomeActivity;
import com.heshmat.learnandroid.models.User;
import com.heshmat.learnandroid.userui.UserHomeActivity;

public class LoginActivity extends AppCompatActivity {
    DatabaseAdapter mDatabaseAdapter;

    @BindView(R.id.signupTv)
    public TextView signupTv;
    @BindView(R.id.signInEmailInL)
    TextInputLayout signInEmailInL;
    @BindView(R.id.signInPasswordInL)
    TextInputLayout signInPasswordInL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getActionBar() != null)
            getActionBar().hide();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mDatabaseAdapter = DatabaseAdapter.getDatabaseAdapter(this);
        String signupStr = "Don't have an account? Sign up";
        SpannableString ss = new SpannableString(signupStr);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, signupStr.indexOf("?") + 1, signupStr.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signupTv.setText(ss);
        signupTv.setMovementMethod(LinkMovementMethod.getInstance());
        signupTv.setHighlightColor(Color.BLUE);
    }

    @OnClick(R.id.signinBt)
    public void signin(View view) {
        if (validateInputNotEmpty(signInEmailInL) && validateInputNotEmpty(signInPasswordInL)) {
            String email = signInEmailInL.getEditText().getText().toString().trim();
            String password = signInPasswordInL.getEditText().getText().toString().trim();
            User user = mDatabaseAdapter.getUser(email, password);
            if (user != null) {
                redirectUser(user);


            } else {
                new AlertDialog.Builder(this).setMessage("Wrong email or password").setPositiveButton("Ok", null).show();


            }


        }


    }

    private void redirectUser(User user) {
        User.currentUser = user;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong("id", User.currentUser.getId()).apply();
        if (user.getRole() == StaticFields.ROLE_USER) {
            startActivity(UserHomeActivity.class);
        } else {
            startActivity(AdminHomeActivity.class);

        }

    }

    private void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }

    private boolean validateInputNotEmpty(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText().getText().toString().trim().isEmpty()) {
            textInputLayout.setError("Required field");
            return false;
        }
        textInputLayout.setError(null);
        return true;
    }

}
