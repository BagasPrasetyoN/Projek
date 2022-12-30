package com.gasstudio.projek;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MonitoringActivity extends AppCompatActivity {
    Button btn_back;
    ImageView btn_monitoring, btn_controlling, btn_aboutus, btn_export;
    TextView seeall;


//    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        btn_monitoring = findViewById(R.id.btn_monitoring);
        btn_controlling = findViewById(R.id.btn_controlling);
        btn_aboutus = findViewById(R.id.btn_aboutus);
        seeall = findViewById(R.id.seeall);

        btn_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonitoringActivity.this, Dashboard.class));
            }
        });

        btn_controlling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ControllingActivity.class));
            }
        });

        btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonitoringActivity.this, AboutUs.class));
            }
        });

        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonitoringActivity.this, AboutUs.class));
            }
        });


    }
}


