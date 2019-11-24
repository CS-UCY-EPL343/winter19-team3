package com.uridecy.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



public class Request  extends AppCompatActivity {
    private Button create;
    private int counter=1;
    private int empty1= 0;
    private int empty2= 0;
    private int empty3= 0;
    private Button muteall;
    private FrameLayout container1;
    private FrameLayout container2;
    private FrameLayout container3;
    public static FragmentManager fragmentManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_request);
       container1 = findViewById(R.id.container);
       container2 =findViewById(R.id.container2);
       container3 = findViewById(R.id.container3);
        muteall = findViewById(R.id.mutebtn);
        muteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    container1.setEnabled(false);
                    container2.setEnabled(false);
                    container3.setEnabled(false);
            }
        });

        create =findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(counter%3 ==1) {
                    counter++;

                    RequestFragment requestFragment = new RequestFragment();
                    if(empty1==0) {
                        fragmentTransaction.add(R.id.container, requestFragment);
                        fragmentTransaction.commit();
                        empty1 =1;
                    }
                    else{
                        fragmentTransaction.replace(R.id.container, requestFragment);
                        fragmentTransaction.commit();
                        empty1 =0;
                    }
                }
                else if(counter%3==2){
                    counter++;
                    RequestFragment requestFragment2 = new RequestFragment();
                    if(empty2==0) {
                        empty2=1;
                        fragmentTransaction.add(R.id.container2, requestFragment2);
                        fragmentTransaction.commit();
                    }
                    else{
                        empty2=0;
                        fragmentTransaction.replace(R.id.container2, requestFragment2);
                        fragmentTransaction.commit();
                    }
                }
                else{
                    counter=1;
                    RequestFragment requestFragment3 = new RequestFragment();
                    if(empty1==0) {
                        empty3 =1;
                        fragmentTransaction.add(R.id.container3, requestFragment3);
                        fragmentTransaction.commit();
                    }
                    else{
                        empty3 =0;
                        fragmentTransaction.replace(R.id.container3, requestFragment3);
                        fragmentTransaction.commit();
                    }
                }


            }
        });

    }

}
