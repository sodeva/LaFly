package sodevan.lafly;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.maps.android.heatmaps.WeightedLatLng;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;

import static com.google.maps.android.SphericalUtil.computeDistanceBetween;

public class Info extends Fragment {

    Context c ;
    FirebaseDatabase database;
    DatabaseReference reference;
    ListView lv;
    TextView tv1;
    GPSTracker gps;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_info ,container  , false) ;
        database=FirebaseDatabase.getInstance();
        reference=database.getReference().child("store");
        gps = new GPSTracker(getContext());
        lv= (ListView) v.findViewById(R.id.lv);
        FirebaseListAdapter<storelistchild> storeAdapter=new FirebaseListAdapter<storelistchild>(getActivity(),storelistchild.class,R.layout.store_child,reference) {
            @Override
            protected void populateView(View v, storelistchild model, int position) {
                tv1= (TextView) v.findViewById(R.id.textView);
                tv1.setText("   "+model.getName());
                LatLng latLng=new LatLng(model.getLatitude(),model.getLongitude());
                Log.d("current","lat="+gps.getLatitude()+"long"+gps.getLongitude());
                Log.d("distance ",latLng.distanceTo(getcurrentlatlng())+"");
            }
        };
    lv.setAdapter(storeAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                storelistchild store= (storelistchild) parent.getItemAtPosition(position);
                Intent i=new Intent(getContext(),Info_father.class);
                i.putStringArrayListExtra("items",store.getItems());
                startActivity(i);

            }
        });
        return v ;
    }

    private LatLng getcurrentlatlng() {
    LatLng current=new LatLng(gps.getLatitude(),gps.getLongitude());
        return current;
    }

    public void setC(Context c) {
        this.c = c;
    }

}
