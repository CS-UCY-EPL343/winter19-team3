package com.example.trial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class LaunchScreen extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private String emailInput;
    private String password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        email = findViewById(R.id.emailField);
        pass = findViewById(R.id.passwordField);
        login = findViewById(R.id.loginButton);

        email.addTextChangedListener(loginTextWatcher);
        pass.addTextChangedListener(loginTextWatcher);
        login.setEnabled(false);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            emailInput  = email.getText().toString().trim();
            password = pass.getText().toString().trim();
            login.setEnabled(!emailInput.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void signUp(View view){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
    public void forgot(View view){
        Intent intent = new Intent(this,ForgotPassword.class);
        startActivity(intent);
    }

    public void goToMainState(View view){
        Intent intent = new Intent(this,MainState.class);
        startActivity(intent);
    }


}
