package sodevan.lafly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Event_father extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_father);
        FirebaseDatabase database;
        DatabaseReference ref;
        database=FirebaseDatabase.getInstance();
        tv1= (TextView) findViewById(R.id.name);
        tv2= (TextView) findViewById(R.id.long_desc);
        tv3= (TextView) findViewById(R.id.by);
        Intent recieve  = getIntent() ;
        String uid = recieve.getStringExtra("uid") ;
        ref=database.getReference("Events").child(uid);
        ValueEventListener listener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("event_name").getValue(String.class);
                String by=dataSnapshot.child("event_by").getValue(String.class);
                String desc=dataSnapshot.child("event_long").getValue(String.class);
                tv1.setText(name);
                tv2.setText(desc);
                tv3.setText(by);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    }
}
