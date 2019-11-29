package com.uridecy.demo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    public static String FILE_NAME = "example.txt";

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
        Intent intent = new Intent(this, com.uridecy.demo.LaunchScreen.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void signUp(View view){
        String newline = "\n";
        if(!(emailInput.contains("@ucy.ac.cy") || emailInput.contains("@cs.ucy.ac.cy"))){
            Toast.makeText(this,"Give only academic email",Toast.LENGTH_LONG).show();
            email.setText("");
            return;
        }
        if(!(password.equals(confirmed))) {
            Toast.makeText(this, "Passwords not the same", Toast.LENGTH_LONG).show();
            pass.setText("");
            confirm.setText("");
            return;
        }
        try (FileOutputStream fos = this.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(emailInput.getBytes());
            fos.write(newline.getBytes());
            fos.write(password.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, LaunchScreen.class);
        startActivity(intent);

        //File file = new File(context.getFilesDir(), "Credentials.txt");
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
