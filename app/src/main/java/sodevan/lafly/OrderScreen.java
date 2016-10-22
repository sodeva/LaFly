package sodevan.lafly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderScreen extends AppCompatActivity {

    Button bt11 ;
    TextView ordertv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        Intent recieve= getIntent() ;
        final String Order = recieve.getStringExtra("orders");

        ordertv = (TextView)findViewById(R.id.mainordertv) ;
        bt11 = (Button)findViewById(R.id.ordernow) ;

        ordertv.setText(Order);

        bt11.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SmsManager ss =SmsManager.getDefault() ;
                                        ss.sendTextMessage("9958265555" ,null , Order , null , null);
                                        finish();
                                    }
                                }

        );


    }
}
