package sodevan.lafly;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class SplashScreen extends AppCompatActivity {

    private static final int splash_Time = 6000 ; // Time in Milliseconds
    TextView splashhead  , tagline , tip1 ;
    String[] tips = {"A woman is the full circle. Within her is the power to create, nurture and transform. \n — Diane Mariechild" ,
            "I love to see a young girl go out and grab the world by the lapels. Life’s a bitch. You’ve got to go out and kick ass. \n — Maya Angelou"
    , " You are more powerful than you know, you are beautiful just as you are. \n — Melissa Etheridge",
            "When you lose a couple of times, it makes you realize how difficult it is to win.\n – Steffi Graff "} ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        splashhead = (TextView)findViewById(R.id.splashhead) ;
        tagline = (TextView)findViewById(R.id.tagline) ;
        tip1 = (TextView)findViewById(R.id.tip) ;



        Typeface tf = Typeface.createFromAsset(getAssets(),"NN.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(),"CaviarDreams.ttf");

        splashhead.setTypeface(tf);
        tagline.setTypeface(tf2);

        Random rand = new Random();
        int r =  rand.nextInt(3) + 1;


        String tip = tips[r] ;

        tip1.setText(tip);

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
