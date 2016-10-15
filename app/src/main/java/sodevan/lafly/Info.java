package sodevan.lafly;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;


public class Info extends Fragment {

    Context c=getContext();
    FirebaseDatabase database;
    DatabaseReference reference;
    ListView lv;
    TextView tv1;
    GPSTracker gps;
    double LAT, LON;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_info, container, false);

        //LOCATION BEGINS
        LocationManager lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        //LOCATION ENDS



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
                Log.d("current","lat="+LAT+"long"+LON);
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
