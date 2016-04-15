/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wehubs.weservice.screens.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.wehubs.weservice.screens.Home;
import com.wehubs.weservice.R;
import com.wehubs.weservice.screens.Registeration.RegisterActivity;


public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressDialog progressDialog;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;
    private Button btnLogin;
    private Button fbLoginButton;
  //  CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.button);
        findViewById(R.id.create_account).setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        handleFacebookLogin();

        presenter = new LoginPresenterImpl(this);
    }

    private void handleFacebookLogin() {
      /*  callbackManager = CallbackManager.Factory.create();
        fbLoginButton = (Button) findViewById(R.id.login_facebook);
        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile", "user_friends"));
            }
        });
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("SUCCESS",""+loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/

    }
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       // callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onResume() {
        super.onResume();
       // AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  AppEventsLogger.deactivateApp(this);
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressDialog.setMessage("Logining in...");
        progressDialog.show();

    }

    @Override public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, Home.class));
        finish();
    }


    @Override public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;
            case R.id.create_account:
                startActivity(new Intent(this, RegisterActivity.class));
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
                break;
        }
    }

}
