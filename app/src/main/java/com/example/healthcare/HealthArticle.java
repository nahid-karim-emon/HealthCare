package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticle extends AppCompatActivity {
    Button btn;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_health_article);
        btn=findViewById (R.id.buttonHABack);
        btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (HealthArticle.this,HomeActivity.class));
            }
        });
        Database db=new Database (getApplicationContext (),"healthCare",null,1);
        ArrayList<HashMap<String, String>> cursor=new ArrayList<> ();
        cursor=db.fetchHealthArticle ();
        ListView lv = (ListView) findViewById(R.id.listViewHA);
        ListAdapter adapter = new SimpleAdapter (HealthArticle.this, cursor, R.layout.multi_articles,new String[]{"name","about"}, new int[]{R.id.line_a, R.id.line_b});
        lv.setAdapter(adapter);

    }
}