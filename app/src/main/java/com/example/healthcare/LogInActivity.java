package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LogInActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edUserName,edPassword;
    Button btn;
    TextView tv;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_log_in);

        edUserName=findViewById (R.id.editTextLoginUserName);
        edPassword=findViewById (R.id.editTextLoginPassword);
        btn=findViewById (R.id.buttonLogin);
        tv=findViewById (R.id.textViewNewUser);
        spinner=findViewById (R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource (this,R.array.usertype,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource (R.layout.spinner_dropdown_layout);
        spinner.setAdapter (adapter);
        spinner.setOnItemSelectedListener (this);
        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String username=edUserName.getText ().toString ();
                String password=edPassword.getText ().toString ();
                String item=spinner.getSelectedItem ().toString ();
                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(username.length ()==0||password.length ()==0||item.length ()==0){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    if(item.equals ("Admin")){
                        if(username.equals ("Nahid") && password.equals ("nahid.180103")){
                            SharedPreferences sharedPreferences = getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit ();
                            editor.putString ("username", "Admin "+username);
                            //to save our data with key and value
                            editor.apply ();
                            startActivity (new Intent (LogInActivity.this,AdminActivity.class));
                        }
                        else{
                            Toast.makeText (getApplicationContext (),"Invalid Admin username or password!!",Toast.LENGTH_SHORT).show ();
                        }
                    }else {
                        if (db.login (username, password) == 1) {
                            Toast.makeText (getApplicationContext (), "LogIn Success", Toast.LENGTH_SHORT).show ();
                            SharedPreferences sharedPreferences = getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit ();
                            editor.putString ("username", username);
                            //to save our data with key and value
                            editor.apply ();
                            startActivity (new Intent (LogInActivity.this, HomeActivity.class));
                        } else {
                            Toast.makeText (getApplicationContext (), "Invalid username or password!!", Toast.LENGTH_SHORT).show ();
                        }
                    }
                }
            }
        });

        tv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (LogInActivity.this,RegistrationActivity.class));
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