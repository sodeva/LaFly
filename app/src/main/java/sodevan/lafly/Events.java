package sodevan.lafly;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        database = FirebaseDatabase.getInstance() ;
        reference = database.getReference("Events");
        ListView lv= (ListView) getActivity().findViewById(R.id.forumevent);
        FirebaseListAdapter<events> eventsFirebaseListAdapter=new FirebaseListAdapter<events>(getActivity(),events.class,R.layout.events_child,reference) {
            @Override
            protected void populateView(View v, events model, int position) {
                TextView tv1= (TextView) v.findViewById(R.id.name_of_event);
                TextView tv2= (TextView) v.findViewById(R.id.event_by);
                TextView tv3=(TextView)v.findViewById(R.id.short_desc);
                String key=model.getEvent_name()+model.getEvent_by();

                tv1.setText(model.getEvent_name());
                tv2.setText(model.getEvent_by());
                tv3.setText(model.getEvent_short());
            }
        };

        lv.setAdapter(eventsFirebaseListAdapter);
        return v ;
    }

    public void setC(Context c) {
        this.c = c;
    }

}
