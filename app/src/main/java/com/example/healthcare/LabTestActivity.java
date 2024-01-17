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

public class LabTestActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_lab_test);
        tv=findViewById (R.id.titleLT);
        btn=findViewById (R.id.buttonLTBack);
        Intent it=getIntent ();
        String title=it.getStringExtra ("title");
        Database db=new Database (getApplicationContext (),"healthCare",null,1);
        tv.setText (title);
        if(title.compareTo ("X-RAY")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("X-RAY");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else
        if(title.compareTo ("X-RAY")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("X-RAY");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("ECG")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("ECG");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("MRI")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("MRI");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("CT-SCAN")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("CT-SCAN");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("EEG")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("EEG");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("ULTRASONOGRAPHY")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("ULTRASONOGRAPHY");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else if(title.compareTo ("ENDOSCOPY")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchDataLT ("ENDOSCOPY");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(LabTestActivity.this, cursor, R.layout.multi_lines,new String[]{"name","type","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }

        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (LabTestActivity.this, LabTestListActivity.class));
            }
        });
    }
}