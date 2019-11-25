package com.uridecy.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;


public class ForgotPassword extends AppCompatActivity {
    private EditText email;
    private Button submit;
    private String emailInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgot_password);
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        email = findViewById(R.id.mail);
        submit = findViewById(R.id.submit);
        email.addTextChangedListener(sub);
        submit.setEnabled(false);
    }

    private TextWatcher sub = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            emailInput  = email.getText().toString().trim();
            submit.setEnabled(!emailInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



}
