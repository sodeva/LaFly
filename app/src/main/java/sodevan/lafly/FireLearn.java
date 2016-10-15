package sodevan.lafly;

import android.app.Application;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kartiksharma on 11/10/16.
 */

public class FireLearn extends Application{
    @Override
    public void onCreate() {
        super.onCreate();


        if(!FirebaseApp.getApps(this).isEmpty()){

            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        }
    }

}
