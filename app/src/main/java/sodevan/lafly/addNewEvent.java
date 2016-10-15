package sodevan.lafly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addNewEvent extends AppCompatActivity {
    FirebaseDatabase database ;
    DatabaseReference reference ;
    Button bt1;
    EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_event);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("Events");
        bt1= (Button) findViewById(R.id.button2);
        et1= (EditText) findViewById(R.id.name_event);
        et2= (EditText) findViewById(R.id.organised_by);
        et3= (EditText) findViewById(R.id.short_desc);
        et4= (EditText) findViewById(R.id.long_desc);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String by=et2.getText().toString();
                String short_desc=et3.getText().toString();
                String long_desc=et4.getText().toString();
                String uid=by+name;
                DatabaseReference newref=reference.child(uid);
                newref.child("event_by").setValue(by);
                newref.child("event_long").setValue(long_desc);
                newref.child("event_name").setValue(name);
                newref.child("event_short").setValue(long_desc);
            }
        });


    }
}
