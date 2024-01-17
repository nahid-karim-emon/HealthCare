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

public class DoctorDetailsActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    //ArrayList<String> doctor_details=new ArrayList<String> ();
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_doctor_details);

        tv=findViewById (R.id.titleDoctorDetails);
        btn=findViewById (R.id.buttonLTBack);
        Intent it=getIntent ();
        String title=it.getStringExtra ("title");
        Database db=new Database (getApplicationContext (),"healthCare",null,1);
        tv.setText (title);

        if(title.compareTo ("Family Physicians")==0){
            ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
            cursor=db.fetchData ("Family Physicians");
            ListView lv = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Dietician")==0){
            ArrayList<HashMap<String, String>> cursor1=new ArrayList<> ();
            cursor1=db.fetchData ("Dietician");
            ListView lv1 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor1, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv1.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Dentist")==0){
            ArrayList<HashMap<String, String>> cursor2=new ArrayList<> ();
            cursor2=db.fetchData ("Dentist");
            ListView lv2 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor2, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv2.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Surgeon")==0){
            ArrayList<HashMap<String, String>> cursor3=new ArrayList<> ();
            cursor3=db.fetchData ("Surgeon");
            ListView lv3 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor3, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv3.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Cardiologists")==0){
            ArrayList<HashMap<String, String>> cursor4=new ArrayList<> ();
            cursor4=db.fetchData ("Cardiologists");
            ListView lv4 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor4, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv4.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Neurologists")==0){
            ArrayList<HashMap<String, String>> cursor5=new ArrayList<> ();
            cursor5=db.fetchData ("Neurologists");
            ListView lv5 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor5, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv5.setAdapter(adapter);
        }
        else
        if(title.compareTo ("Orthopedics")==0){
            ArrayList<HashMap<String, String>> cursor6=new ArrayList<> ();
            cursor6=db.fetchData ("Orthopedics");
            ListView lv6 = (ListView) findViewById(R.id.listViewLT);
            ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor6, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
            lv6.setAdapter(adapter);
        }

        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        /*sa=new SimpleAdapter (this,cursor,R.layout.multi_lines,new String[]{"line1","line2","line3","line4"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d});

        ListView lst=findViewById (R.id.listDoctorDetails);
        lst.setAdapter (sa);*/

        /*ListView lv = (ListView) findViewById(R.id.listDoctorDetails);
        ListAdapter adapter = new SimpleAdapter(DoctorDetailsActivity.this, cursor, R.layout.multi_lines,new String[]{"name","chember","mobile","fees"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c,R.id.line_d});
        lv.setAdapter(adapter);*/
    }
}