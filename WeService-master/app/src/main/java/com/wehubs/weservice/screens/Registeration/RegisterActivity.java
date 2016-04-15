package com.wehubs.weservice.screens.Registeration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wehubs.weservice.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    public void backToLogin(View view) {
        finish();
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

    }
}
