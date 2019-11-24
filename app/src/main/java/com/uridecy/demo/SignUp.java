package com.uridecy.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private EditText confirm;
    private Button signUp;
    private CheckBox agree;
    private String emailInput;
    private String password;
    private String confirmed;
    private Boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
       confirm = findViewById(R.id.confirmpass);
       signUp = findViewById(R.id.signup_button);
       agree  = findViewById(R.id.terms_of_service);

        email.addTextChangedListener(signUpTextWatcher);
        pass.addTextChangedListener(signUpTextWatcher);
        confirm.addTextChangedListener(signUpTextWatcher);
        agree.addTextChangedListener(signUpTextWatcher);
        signUp.setEnabled(false);

    }
    public void terms(View view){
        Intent intent = new Intent(this,TermsAndConditions.class);
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this,LaunchScreen.class);
        startActivity(intent);
    }


    private TextWatcher signUpTextWatcher  = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            emailInput  = email.getText().toString().trim();
            password = pass.getText().toString().trim();
            confirmed = confirm.getText().toString().trim();
            //checked = agree.isChecked();

                signUp.setEnabled(!emailInput.isEmpty() && !password.isEmpty() && !confirmed.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
