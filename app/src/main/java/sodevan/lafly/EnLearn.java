package sodevan.lafly;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnLearn  extends Fragment {
    private ListView lv;
    FirebaseDatabase database;
    DatabaseReference ref;

    Context c ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_en_learn, container, false);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Enlearn Videos");
        lv = (ListView) v.findViewById(R.id.enlearnlistview);
/*


        FirebaseListAdapter<VideoChild> fb = new FirebaseListAdapter<VideoChild>(getActivity(), VideoChild.class, R.layout.videochild, ref) {
            @Override
            protected void populateView(View v, VideoChild model, int position) {
                String url=model.getURL();
                String date=model.getDate();
                String name=model.getName();
                TextView Date=(TextView)v.findViewById(R.id.date);
                TextView Name=(TextView)v.findViewById(R.id.heading);
                TextView URL=(TextView)v.findViewById(R.id.url);
                Name.setText(name);
                URL.setText(url);

                Date.setText(date);



            }


        };
        lv.setAdapter(fb);
        return v ;

    }*/
        return v;
    }
    public void setC(Context c) {
        this.c = c;
    }

}
