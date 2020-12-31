package com.heshmat.learnandroid.userui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.heshmat.learnandroid.LoginActivity;
import com.heshmat.learnandroid.R;
import com.heshmat.learnandroid.models.Topic;
import com.heshmat.learnandroid.models.User;
import com.mikhaellopez.circularimageview.CircularImageView;

public class UserHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.userDrawer)
    DrawerLayout drawer;
    @BindView(R.id.userNested)
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    TextView drawerUserNameTv;
    TextView drawerUserEmailTv;
    CircularImageView userIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                //  hideKeyboard(HomeActivity.this);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                if (fragment != null) {
                    showFragment(fragment);

                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        View hederView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.drawer_header, navigationView);

        drawerUserNameTv = hederView.findViewById(R.id.drawerUserNameTv);
        drawerUserEmailTv = hederView.findViewById(R.id.drawerUserEmailTv);
        userIv = hederView.findViewById(R.id.userIv);
        initializeUserUiInfo();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, TopicsFragment.newInstance())
                    .commit();
        }


    }

    Class fragment = null;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        closeDrawer();
        switch (item.getItemId()) {
            case R.id.profileMenuItem:
                break;

            case R.id.TopicsMenuItem:
                fragment=TopicsFragment.class;
                break;

            case R.id.logoutMenuItem:

                logout();

                break;
        }
        closeDrawer();
        return false;
    }

    public void showFragment(Class fragmentClass) {
        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (!currentFragment.getClass().getName().equals(fragmentClass.getName())) {
            fragmentManager.beginTransaction()
                    //  .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragmentContainer, fragment, fragmentClass.getName()).addToBackStack(null)
                    .commit();

        }
    }

    private void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    private void initializeUserUiInfo() {
        if (User.currentUser != null) {
            if (User.currentUser.getName() != null)
                drawerUserNameTv.setText(User.currentUser.getName());
            if (User.currentUser.getEmail() != null)
                drawerUserEmailTv.setText(User.currentUser.getEmail());
            if (User.currentUser.getImgUrl() != null) {
                Glide.with(this).load(User.currentUser.getImgUrl()).into(userIv);

            }
        }
    }

    public void logout() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong("id", -1).apply();
        User.currentUser = null;
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
