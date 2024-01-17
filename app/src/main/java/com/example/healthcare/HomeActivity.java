package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home);

        SharedPreferences sharedPreferences=getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString ("username","").toString ();
        Toast.makeText (getApplicationContext (), "Welcome "+username, Toast.LENGTH_SHORT).show ();

        LinearLayout exit=findViewById (R.id.homeExit);
        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit ();
                editor.clear ();
                editor.apply ();
                startActivity (new Intent (HomeActivity.this,LogInActivity.class));
            }
        });

        LinearLayout findDoctor=findViewById (R.id.homeFindDoctor);
        findDoctor.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (HomeActivity.this,FindDoctorActivity.class));
            }
        });

        LinearLayout labTest=findViewById (R.id.homeLabTest);
        labTest.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (HomeActivity.this,LabTestListActivity.class));
            }
        });

        LinearLayout findAmbulance=findViewById (R.id.homeBuyMedicine);
        findAmbulance.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (HomeActivity.this,FindEmergencyAmbulanceActivity.class));
            }
        });

        LinearLayout healthArticle=findViewById (R.id.homeHealthDoctor);
        healthArticle.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (HomeActivity.this,HealthArticle.class));
            }
        });

    }
}