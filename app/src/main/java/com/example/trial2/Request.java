package com.example.trial2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



public class Request  extends AppCompatActivity {
    private Button create;
    public static FragmentManager fragmentManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_request);


        create =findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RequestFragment requestFragment =new RequestFragment();
                fragmentTransaction.add(R.id.container,requestFragment);
                fragmentTransaction.commit();
            }
        });

    }

}
