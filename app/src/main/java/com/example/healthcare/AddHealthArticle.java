package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddHealthArticle extends AppCompatActivity {

    EditText addHAName,addHADetails;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_health_article);
        addHAName=findViewById (R.id.addDiseaseName);
        addHADetails=findViewById (R.id.addAboutDisease);
        btn=findViewById (R.id.addHAbtn);
        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String HAName="Disease Name: "+addHAName.getText ().toString ();
                String about="About: "+addHADetails.getText ().toString ();
                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(HAName.length ()==14||about.length ()==7){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    db.addHADatabase (HAName,about);
                    Toast.makeText (getApplicationContext (),"Add Health Article Successfully!",Toast.LENGTH_SHORT).show ();
                    startActivity (new Intent (AddHealthArticle.this,AdminActivity.class));
                }
            }
        });
    }
}