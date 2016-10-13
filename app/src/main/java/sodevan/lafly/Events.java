package sodevan.lafly;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Events extends Fragment {
    FirebaseDatabase database ;
    DatabaseReference reference ;
    Context c ;
//sdgsdgdafad
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_events ,container  , false) ;
        setHasOptionsMenu(true);
        database = FirebaseDatabase.getInstance() ;

        reference = database.getReference("Events");
        ListView lv= (ListView) v.findViewById(R.id.forumevent);
        FirebaseListAdapter<eventschild> eventsFirebaseListAdapter=new FirebaseListAdapter<eventschild>(getActivity(),eventschild.class,R.layout.events_child,reference) {
            @Override
            protected void populateView(View v, eventschild model, int position) {
                TextView tv1= (TextView) v.findViewById(R.id.name_of_event);
                TextView tv2= (TextView) v.findViewById(R.id.event_by);
                TextView tv3=(TextView)v.findViewById(R.id.short_desc);
                final String keya=model.getEvent_name()+model.getEvent_by();

                tv1.setText(model.getEvent_name());
                tv2.setText(model.getEvent_by());
                tv3.setText(model.getEvent_short());
            }
        };

        lv.setAdapter(eventsFirebaseListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Code for onitemclick
                eventschild q =(eventschild) parent.getItemAtPosition(position) ;
                String uid=q.getEvent_name()+q.getEvent_by();
                Intent i=new Intent(getContext(),Event_father.class);
                i.putExtra("uid",uid);
                startActivity(i);
                Log.d("position of click",position+"    -    "+id);

            }
        });
        return v ;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
                 case R.id.addques:
                    Log.d("Click","Hua re baab");
                  Intent i=new Intent(getContext(),addNewEvent.class);
             startActivity(i);
        }
return true;
    }

    public void setC(Context c) {
        this.c = c;
    }

}
