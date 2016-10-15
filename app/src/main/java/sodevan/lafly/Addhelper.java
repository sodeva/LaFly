package sodevan.lafly;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addhelper extends AppCompatActivity {

    SharedPreferences sp ;
    Button btn1 ;
    EditText et1 , et2 ;
    int fnou ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhelper);


        btn1 = (Button)findViewById(R.id.adhsubmit) ;
        et1= (EditText)findViewById(R.id.adhname) ;
        et2 = (EditText)findViewById(R.id.adhno) ;


        sp = PreferenceManager.getDefaultSharedPreferences(this) ;
        int nou =sp.getInt("Nou" , 0 ) ;
        Log.e("n" , nou+"") ;
        fnou = nou+1 ;




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et1.getText().toString()  ;
                String phone = et2.getText().toString() ;
                sp.edit().putString("Username"+fnou , name).commit() ;
                sp.edit().putString("Userno"+fnou , phone).commit() ;
                sp.edit().putInt("Nou" ,fnou).commit() ;

                finish();
            }
        });





    }
}
