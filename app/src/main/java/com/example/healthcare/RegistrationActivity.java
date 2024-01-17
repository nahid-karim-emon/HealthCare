package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText edUserName,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_registration);

        edUserName=findViewById (R.id.editTextAppFullName);
        edEmail=findViewById (R.id.editTextAppAddress);
        edPassword=findViewById (R.id.editTextAppContactNumber);
        edConfirm=findViewById (R.id.editTextAppFees);
        btn=findViewById (R.id.AppBookAppoinment);
        tv=findViewById (R.id.textViewExistingUser);

        tv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (RegistrationActivity.this,LogInActivity.class));
            }
        });

        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String username=edUserName.getText ().toString ();
                String email=edEmail.getText ().toString ();
                String password=edPassword.getText ().toString ();
                String confirmPassword=edConfirm.getText ().toString ();
                Database db=new Database (getApplicationContext (),"healthCare",null,1);
                if(username.length ()==0||password.length ()==0||email.length ()==0||confirmPassword.length ()==0){
                    Toast.makeText (getApplicationContext (),"Please Fill All Details!!",Toast.LENGTH_SHORT).show ();
                }else{
                    if(password.compareTo (confirmPassword)==0){
                        if(isValid (password)){
                            db.register (username,email,password);
                            Toast.makeText (getApplicationContext (),"Registration Success",Toast.LENGTH_SHORT).show ();
                            startActivity (new Intent (RegistrationActivity.this,LogInActivity.class));
                        }else{
                            Toast.makeText (getApplicationContext (),"Password must contain at least 6 character having letter,digit and special symbol!",Toast.LENGTH_SHORT).show ();
                        }
                    }
                    else{
                        Toast.makeText (getApplicationContext (),"Password and Confirm Password Didn't match!!",Toast.LENGTH_SHORT).show ();
                    }
                }
            }
        });
    }
    public static boolean isValid(String passwordHere){
        int f1=0,f2=0,f3=0;
        if(passwordHere.length ()<6){
            return false;
        }else{
            for(int p=0;p<passwordHere.length ();p++){
                if(Character.isLetter (passwordHere.charAt (p))){
                    f1=1;
                }
            }
            for(int p=0;p<passwordHere.length ();p++){
                if(Character.isDigit (passwordHere.charAt (p))){
                    f2=1;
                }
            }
            for(int p=0;p<passwordHere.length ();p++){
                char c=passwordHere.charAt (p);
                if(c>=33 && c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
            return  false;
        }
    }
}