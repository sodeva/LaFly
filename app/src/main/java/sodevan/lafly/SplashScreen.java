package sodevan.lafly;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static final int splash_Time = 3000 ; // Time in Milliseconds
    TextView splashhead  , tagline;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        splashhead = (TextView)findViewById(R.id.splashhead) ;
        tagline = (TextView)findViewById(R.id.tagline) ;


        Typeface tf = Typeface.createFromAsset(getAssets(),"NN.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(),"CaviarDreams.ttf");

        splashhead.setTypeface(tf);
        tagline.setTypeface(tf2);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent change_home = new Intent(getApplicationContext() , Login.class) ;
                startActivity(change_home);
                finish();
            }
        } , splash_Time) ;

    }
}
