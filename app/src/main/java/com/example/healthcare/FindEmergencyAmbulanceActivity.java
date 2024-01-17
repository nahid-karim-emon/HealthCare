package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class FindEmergencyAmbulanceActivity extends AppCompatActivity {

    Button btn;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_find_emergency_ambulance);
        btn=findViewById (R.id.buttonAmbulanceBack);
        Intent it=getIntent ();
        String title=it.getStringExtra ("title");
        Database db=new Database (getApplicationContext (),"healthCare",null,1);
        ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
        cursor=db.fetchAmbulance ();
        ListView lv = (ListView) findViewById(R.id.listViewAmbulance);
        ListAdapter adapter = new SimpleAdapter(FindEmergencyAmbulanceActivity.this, cursor, R.layout.multi_lines,new String[]{"name","hospital","mobile",null}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
        lv.setAdapter(adapter);

        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (FindEmergencyAmbulanceActivity.this,HomeActivity.class));
            }
        });
    }
}