package sodevan.lafly;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.LOCATION_SERVICE;


public class Info extends Fragment {

    Context c = getContext();
    HashMap<String , Float > cart  ;
    ArrayList<StoreItem> storeItems ;
    CustomStoreAdapter adapter ;
    ListView lv ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View V= inflater.inflate(R.layout.activity_info, container, false);

        storeItems = new ArrayList<>() ;
        cart = new HashMap<String, Float>()  ;

        lv = (ListView)V.findViewById(R.id.lvstore) ;

        storeItems.add(new StoreItem("Friends Maternity Pads" , 169 , R.drawable.a1  ) ) ;
        storeItems.add(new StoreItem("Stayfree Dry Max Ultra Dry" , 155 ,R.drawable.a2));
        storeItems.add(new StoreItem("Carefree Sanitary Pads" , 135 ,R.drawable.a3));
        storeItems.add(new StoreItem("Tresemme Spa Rejuvenation Conditioner" , 204 ,R.drawable.a4));
        storeItems.add(new StoreItem("Whisper Choice Regular wings" , 570 ,R.drawable.a5));
        storeItems.add(new StoreItem("Nike Up or Down Deodorant(women)" , 184 ,R.drawable.a6));
        storeItems.add(new StoreItem("Revital H Woman " , 269 ,R.drawable.a7));
        storeItems.add(new StoreItem(".Trophic Wellness Nuticharge" , 302 ,R.drawable.a8));
        storeItems.add(new StoreItem("Nivea Whitening Skin Roll" , 131 ,R.drawable.a9));
        storeItems.add(new StoreItem("Gillette Venus Gift Pack" , 549 ,R.drawable.a10));


        adapter = new CustomStoreAdapter(c , 0 ,storeItems) ;


        lv.setAdapter(adapter);



        return V ;
    }




    public void setC(Context c) {
        this.c = c;
    }


    public class CustomStoreAdapter extends ArrayAdapter<StoreItem> {



        public CustomStoreAdapter(Context context, int resource , ArrayList<StoreItem> items) {
            super(context,resource,items);

        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            if (v==null){
                v=getActivity().getLayoutInflater().inflate(R.layout.store_child,parent,false);
            }
          final  StoreItem child=storeItems.get(position);





                TextView tv1 = (TextView) v.findViewById(R.id.nameitem);
                TextView tv2 = (TextView) v.findViewById(R.id.price);
                CheckBox ch = (CheckBox) v.findViewById(R.id.checkbox1) ;
                ImageView im = (ImageView) v.findViewById(R.id.imageView2) ;
                im.setImageResource(child.getImage());
                tv1.setText(child.getIname());
                tv2.setText(child.getPrice()+"");

                ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){

                            cart.put( child.getIname() , child.getPrice()) ;
                        }


                        else {

                            cart.remove( child.getIname()) ;

                        }
                    }
                });




            return v;


        }
    }


}
