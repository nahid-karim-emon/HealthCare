package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_find_doctor);

        LinearLayout exit = findViewById (R.id.FindDoctorBack);
        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (FindDoctorActivity.this, HomeActivity.class));
            }
        });

        LinearLayout familyPhysician = findViewById (R.id.findDoctorFamilyPhysicians);
        familyPhysician.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra ("title", "Family Physicians");
                startActivity (it);
            }
        });
        LinearLayout dietician = findViewById (R.id.findDoctorDietician);
        dietician.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra ("title", "Dietician");
                startActivity (it);
            }
        });

        LinearLayout dentist=findViewById (R.id.findDoctorDentist);
        dentist.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra ("title","Dentist");
                startActivity (it);
            }
        });
        LinearLayout surgeon=findViewById (R.id.findDoctorSurgeon);
        surgeon.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra ("title","Surgeon");
                startActivity (it);
            }
        });
        LinearLayout cardiologists=findViewById (R.id.findDoctorCardiologists);
        cardiologists.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra ("title","Cardiologists");
                startActivity (it);
            }
        });
        LinearLayout neurologists=findViewById (R.id.findDoctorNeurologists);
        neurologists.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra ("title","Neurologists");
                startActivity (it);
            }
        });
        LinearLayout orthopedics=findViewById (R.id.findDoctorOrthopedics);
        orthopedics.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra ("title","Orthopedics");
                startActivity (it);
            }
        });
    }

}