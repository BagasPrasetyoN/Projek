package com.gasstudio.projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {
    TextView distance,ph,tinggi;
    MeowBottomNavigation bottomNavigation;
    DatabaseReference dref;
    Object data1,data2,data3;
    String a;
    String b;
    String c;
    //        firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        distance=(TextView) findViewById(R.id.kekeruhan) ;
        ph=(TextView)findViewById(R.id.nilaiph1) ;
        tinggi=(TextView)findViewById(R.id.tinggiair1) ;

               dref = FirebaseDatabase.getInstance().getReference();
               dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        a = dataSnapshot.child("data2").getValue().toString();
                        b = dataSnapshot.child("data1").getValue().toString();
                        c = dataSnapshot.child("data5").getValue().toString();
                        distance.setText(a);
                        ph.setText(b);
                        tinggi.setText(c);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        bottomNavigation = findViewById(R.id.bottom_navigasi);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_monitor_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_settings_applications_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new Fragment();
                        break;
                    case 2:
                        fragment = new Fragment();
                        break;
                }
                loadFragment(fragment);
            }
        });
        bottomNavigation.setCount(1,"10");
        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                    ,"You Clicked" + item.getId()
                    ,Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                ,"You Reslected" + item.getId()
                ,Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    public void onDataChange(DataSnapshot snapshot) {
//        String kekeruhan = snapshot.child("data1").getValue().toString();
//        String kekeruhan = snapshot.child("data2").getValue().toString();
//        String kekeruhan = snapshot.child("data3").getValue().toString();
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//
//    @Override
//    protected void onStart(){
//        super.onStart();
//        data1.addValueEventListener(this);
//        data2.addValueEventListener(this);
//        data3.addValueEventListener(this);
//    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();

    }



}