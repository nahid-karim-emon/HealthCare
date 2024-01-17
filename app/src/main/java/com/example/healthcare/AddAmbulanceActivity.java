package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddAmbulanceActivity extends AppCompatActivity {

    EditText driverName,hospitalName,mobileNb;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_ambulance);
        driverName=findViewById (R.id.addDriverName);
        hospitalName=findViewById (R.id.addAmbulanceHospitalName);
        mobileNb=findViewById (R.id.addAmbulancePhnNb);
        btn=findViewById (R.id.addAmbulanceBtn);

        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String name="Driver Name: "+driverName.getText ().toString ();
                String hospital="Hospital: "+hospitalName.getText ().toString ();
                String mobile="Mobile: "+mobileNb.getText ().toString ();

                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(name.length ()==13||hospital.length ()==10||mobile.length ()==8){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    db.addAmbulanceDatabase (name,hospital,mobile);
                    Toast.makeText (getApplicationContext (),"Add Ambulance Successfully!",Toast.LENGTH_SHORT).show ();
                    startActivity (new Intent (AddAmbulanceActivity.this,AdminActivity.class));
                }
            }
        });
    }

}