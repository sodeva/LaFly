package sodevan.lafly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    FirebaseDatabase database ;
    DatabaseReference reference ;
    EditText etname , etno ;
    TextView tvlh ;
    Button bt1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()) ;
        String Uid = sp.getString("Uid" , "K3PHIJQL") ;

        if(!Uid.equals("K3PHIJQL")){

            Intent changehome = new Intent(getApplicationContext() , Home.class) ;
            startActivity(changehome);
            finish();


        }



        database= FirebaseDatabase.getInstance() ;
        reference = database.getReference("Users") ;

        Typeface tf2 = Typeface.createFromAsset(getAssets(),"CaviarDreams.ttf");


        etname =(EditText)findViewById(R.id.etname) ;
        etno =(EditText)findViewById(R.id.etcontactno) ;
        tvlh =(TextView)findViewById(R.id.loginhead) ;
        bt1=(Button)findViewById(R.id.Loginbutton)  ;

        etname.setTypeface(tf2);
        etno.setTypeface(tf2);
        tvlh.setTypeface(tf2);
        bt1.setTypeface(tf2);


        etname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.etshapefocus);
                }

                else {
                    v.setBackgroundResource(R.drawable.etshape);

                }
            }
        });


        etno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus){
                    v.setBackgroundResource(R.drawable.etshapefocus);
                }

                else {
                    v.setBackgroundResource(R.drawable.etshape);

                }

            }
        });



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString() ;
                String no = etno.getText().toString() ;
                Boolean networkstatus = haveNetworkConnection() ;


                if(name.equals("") || no.equals("") || !networkstatus){

                    if (name.equals("") || no.equals(""))
                    Toast.makeText(getApplicationContext(), "Fill The Following Fields", Toast.LENGTH_SHORT).show();

                    else {
                        Toast.makeText(getApplicationContext(), "Check Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    String Uid = name+no ;

                    reference.child(Uid).child("name").setValue(name)  ;
                    reference.child(Uid).child("contact").setValue(no)  ;

                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()) ;
                    sp.edit().putString("Uid",Uid).commit() ;
                    sp.edit().putString("name",name).commit() ;
                    sp.edit().putString("no",no).commit() ;
                    Toast.makeText( getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                    Intent changehome = new Intent(getApplicationContext() , Home.class) ;
                    startActivity(changehome);
                    finish();


                }

            }
        });




    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
