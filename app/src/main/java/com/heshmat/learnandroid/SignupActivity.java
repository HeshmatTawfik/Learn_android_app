package com.heshmat.learnandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.heshmat.learnandroid.models.User;
import com.heshmat.learnandroid.userui.UserHomeActivity;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
    File file;
    Uri muri;
    DatabaseAdapter mDatabaseAdapter;

    @BindView(R.id.profile_imageView)
    CircularImageView image;
    @BindView(R.id.signUpNameInL)
    TextInputLayout signUpNameInL;
    @BindView(R.id.signUpEmailInL)
    TextInputLayout signUpEmailInL;
    @BindView(R.id.passwordSignUplInL)
    TextInputLayout passwordSignUplInL;
    @BindView(R.id.confirmPasswordInL)
    TextInputLayout confirmPasswordInL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getActionBar() != null)
            getActionBar().hide();
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mDatabaseAdapter = DatabaseAdapter.getDatabaseAdapter(this);


    }

    @OnClick(R.id.img_plus)
    public void chooseProfileImg(View view) {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                muri = result.getUri();
                try {
                    file = new File(String.valueOf(resultUri));
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                    file.getAbsolutePath();
                    Glide.with(this).load(bitmap).into(image);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    @OnClick(R.id.signUpBt)
    public void signUp(View view) {
        User user = new User(StaticFields.ROLE_USER, signUpNameInL.getEditText().getText().toString(), signUpEmailInL.getEditText().getText().toString(), passwordSignUplInL.getEditText().getText().toString(), muri.toString());

        try {
            User.currentUser = mDatabaseAdapter.insertUser(user);
            if (User.currentUser != null) {
                Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                sharedPreferences.edit().putLong("id", User.currentUser.getId()).apply();
                startActivity(new Intent(SignupActivity.this, UserHomeActivity.class));
                finish();

            }

        } catch (SQLiteConstraintException e) {
            new AlertDialog.Builder(this).setMessage("This email already linked to another account").setPositiveButton("Ok", null).show();

        }

    }
}
