package com.wehubs.weservice.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wehubs.weservice.R;
import com.wehubs.weservice.screens.Login.LoginActivity;

public class Home extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
private ImageView userImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userImage = (ImageView)findViewById(R.id.user_image);
        setUserDetail();
        setNavigateView(toolbar);
    }

    private void setUserDetail() {
     Glide
                .with(Home.this)
                .load("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xfp1/t31.0-8/s960x960/12628588_1140226072694917_736641052253016678_o.jpg")
                .centerCrop()
                .placeholder(R.drawable.default_profile)
                .crossFade()
                .into(userImage);
    }

    private void setNavigateView(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.share_app) {
            // Handle the camera action
        } else if (id == R.id.feedback) {

        } else if (id == R.id.rate) {

        } else if (id == R.id.visit_website) {

        } else if (id == R.id.logout) {
            startActivity(new Intent(Home.this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onRequestServiceClick(View view) {
        startActivity(new Intent(Home.this,MainActivity.class));
    }

    public void onSubmitServiceClick(View view) {
    }

    public void onMyProfileClick(View view) {
    }

    public void onMyInboxClick(View view) {
    }
}
