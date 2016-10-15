package sodevan.lafly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigureLalife extends AppCompatActivity {

    Button btn1 ,btn2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_lalife);

        btn1 = (Button)findViewById(R.id.addhelper) ;
        btn2= (Button)findViewById(R.id.viewhelper) ;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add = new Intent(getApplicationContext() ,Addhelper.class) ;
                startActivity(add);



            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
