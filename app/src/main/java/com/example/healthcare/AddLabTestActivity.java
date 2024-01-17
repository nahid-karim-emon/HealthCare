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

public class AddLabTestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText addHospital,addMobile,addFees;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_lab_test);
        Spinner addType=findViewById (R.id.spinner);
        addHospital=findViewById (R.id.addHospitalName);
        addMobile=findViewById (R.id.addCounterMobile);
        addFees=findViewById (R.id.addTestFees);
        btn=findViewById (R.id.addLTBtn);
        ArrayAdapter adapter=ArrayAdapter.createFromResource (this,R.array.listLT,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource (R.layout.spinner_dropdown_layout);
        addType.setAdapter (adapter);
        addType.setOnItemSelectedListener (this);
        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String type=addType.getSelectedItem ().toString ();
                String name="Hospital Name: "+addHospital.getText ().toString ();
                String mobile="Contact: "+addMobile.getText ().toString ();
                String fees="Test Fees: "+addFees.getText ().toString ();
                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(type.length ()==0||name.length ()==0||mobile.length()==0||fees.length ()==0){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    db.addLabTestDatabase (type,name,mobile,fees);
                    Toast.makeText (getApplicationContext (),"Add Lab Test Successfully!",Toast.LENGTH_SHORT).show ();
                    startActivity (new Intent (AddLabTestActivity.this,AdminActivity.class));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText (this,adapterView.getSelectedItem ().toString (),Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}