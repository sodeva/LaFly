package sodevan.lafly;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ronaksakhuja on 14/10/16.
 */

public class storelistchild {
    ArrayList<String> items;
    double latitude;
    double longitude;
    String name;
    public storelistchild(){}
    public storelistchild(ArrayList<String> items,double latitude,double longitude,String name){
        this.items=items;
        this.latitude=latitude;
        this.longitude=longitude;
        this.name=name;

    }
    public ArrayList<String> getItems() {
        return items;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }



}

