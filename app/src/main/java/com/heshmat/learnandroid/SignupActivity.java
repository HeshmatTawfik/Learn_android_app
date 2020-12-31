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
import android.util.Patterns;
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
import java.util.regex.Pattern;

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
        if(validateForm()) {
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

    public boolean checkImg() {
        if (muri == null) {
            new AlertDialog.Builder(this).setMessage("Please choose an image").setPositiveButton("ok", null).show();
            return false;
        }
        return true;
    }

    public boolean validatePassword() {
        String password = passwordSignUplInL.getEditText().getText().toString();
        String confirmPass = confirmPasswordInL.getEditText().getText().toString();
        if (password.trim().isEmpty()) {
            passwordSignUplInL.setError(getString(R.string.required_field));
            return false;
        }
        if (confirmPass.trim().isEmpty()) {
            confirmPasswordInL.setError(getString(R.string.required_field));
            return false;
        }
        if (password.trim().length() < 8) {
            passwordSignUplInL.setError("Must be at least 8 characters");
            return false;
        }
        if (!password.equals(confirmPass)) {
            passwordSignUplInL.setError("Password and confirm password must match");
            confirmPasswordInL.setError("");
            return false;
        }
        passwordSignUplInL.setError(null);
        confirmPasswordInL.setError(null);

        return true;
    }

    public boolean validateEmail() {
        if (signUpEmailInL.getEditText().getText().toString().trim().isEmpty()) {

            signUpEmailInL.setError(getString(R.string.required_field));
            return false;
        }
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        if (!pattern.matcher(signUpEmailInL.getEditText().getText().toString()).matches()) {
            signUpEmailInL.setError("Invalid email");
            return false;
        }
        signUpEmailInL.setError(null);
        return true;

    }
    public boolean validateName() {
        if (signUpNameInL.getEditText().getText().toString().trim().isEmpty()) {

            signUpNameInL.setError(getString(R.string.required_field));
            return false;

        }

        signUpNameInL.setError(null);
        return true;

    }
    public boolean validateForm(){
        checkImg();
        validateName();
        validateEmail();
        validatePassword();
        return checkImg()&&validateName()&&validateName()&&validatePassword();
    }
}
