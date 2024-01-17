package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin);

        LinearLayout add_doctor=findViewById (R.id.adminPanelAddDoctor);
        add_doctor.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,AddDoctor.class));
            }
        });

        LinearLayout update_doctor=findViewById (R.id.adminPanelUpdateDoctor);
        update_doctor.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,UpdateChemberActivity.class));
            }
        });

        LinearLayout labtest=findViewById (R.id.adminPanelAddLT);
        labtest.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,AddLabTestActivity.class));
            }
        });

        LinearLayout logout=findViewById (R.id.adminPanelLogOut);
        logout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,LogInActivity.class));
            }
        });

        LinearLayout addAmbulance=findViewById (R.id.adminPanelAddAmbulance);
        addAmbulance.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,AddAmbulanceActivity.class));
            }
        });

        LinearLayout addHealthArticle=findViewById (R.id.adminPanelAddHealthArticle);
        addHealthArticle.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (AdminActivity.this,AddHealthArticle.class));
            }
        });

    }
}