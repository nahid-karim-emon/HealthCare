package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class LabTestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_lab_test_list);
        LinearLayout exit = findViewById (R.id.LabTestBack);
        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (LabTestListActivity.this, HomeActivity.class));
            }
        });

        LinearLayout xry = findViewById (R.id.LabTestXray);
        xry.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (LabTestListActivity.this, LabTestActivity.class);
                it.putExtra ("title", "X-RAY");
                startActivity (it);
            }
        });
        LinearLayout ecg = findViewById (R.id.LabTestEcg);
        ecg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (LabTestListActivity.this, LabTestActivity.class);
                it.putExtra ("title", "ECG");
                startActivity (it);
            }
        });

        LinearLayout mri=findViewById (R.id.LabListMri);
        mri.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (LabTestListActivity.this,LabTestActivity.class);
                it.putExtra ("title","MRI");
                startActivity (it);
            }
        });
        LinearLayout ctscan=findViewById (R.id.LabTestCtScan);
        ctscan.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (LabTestListActivity.this,LabTestActivity.class);
                it.putExtra ("title","CT-SCAN");
                startActivity (it);
            }
        });
        LinearLayout eeg=findViewById (R.id.LabTestEeg);
        eeg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (LabTestListActivity.this,LabTestActivity.class);
                it.putExtra ("title","EEG");
                startActivity (it);
            }
        });
        LinearLayout ultra=findViewById (R.id.LabTestUltrasonography);
        ultra.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (LabTestListActivity.this,LabTestActivity.class);
                it.putExtra ("title","ULTRASONOGRAPHY");
                startActivity (it);
            }
        });
        LinearLayout endo=findViewById (R.id.LabTestEndoscopy);
        endo.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (LabTestListActivity.this,LabTestActivity.class);
                it.putExtra ("title","ENDOSCOPY");
                startActivity (it);
            }
        });
    }
}