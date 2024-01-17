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

public class UpdateChemberActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText addID,addName,addChember,addMobile,addFees;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_update_chember);
        addID=findViewById (R.id.addDoctorID);
        Spinner addType=findViewById (R.id.spinner);
        addName=findViewById (R.id.addDoctorName);
        addChember=findViewById (R.id.addDoctorCember);
        addMobile=findViewById (R.id.addDoctorMobile);
        addFees=findViewById (R.id.addDoctorFees);
        btn=findViewById (R.id.addDoctorBtn);
        ArrayAdapter adapter=ArrayAdapter.createFromResource (this,R.array.listType,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource (R.layout.spinner_dropdown_layout);
        addType.setAdapter (adapter);
        addType.setOnItemSelectedListener (this);
        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String id=addID.getText ().toString ();
                String type=addType.getSelectedItem ().toString ();
                String name="Name: "+addName.getText ().toString ();
                String chember="Chember: "+addChember.getText ().toString ();
                String mobile="Mobile: "+addMobile.getText ().toString ();
                String fees="Fees: "+addFees.getText ().toString ();
                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(id.length ()==0||type.length ()==0||name.length ()==6||chember.length ()==9||mobile.length()==8||fees.length ()==6){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    Boolean x=db.UpdateDoctorDatabase (id,type,name,chember,mobile,fees);
                    if(x) {
                        Toast.makeText (getApplicationContext (), "Update Doctor Successfully!", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (UpdateChemberActivity.this, AdminActivity.class));
                    }
                    else{
                        Toast.makeText (getApplicationContext (), "Update Error!", Toast.LENGTH_SHORT).show ();
                    }
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