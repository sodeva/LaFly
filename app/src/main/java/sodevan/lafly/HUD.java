package sodevan.lafly;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

public class HUD extends Service implements View.OnTouchListener {


    private RelativeLayout Parent;
    private int initialX;
    private int initialY;
    private float initialTouchX;
    private float initialTouchY;
    private boolean moving;
    private WindowManager wm;
    private int winHeight = 0;
    private int winWidth = 0;
    private GradientDrawable shape, shape2;
    private Handler handler;
    private Button menuButton;
    private ImageView button;
    private WindowManager.LayoutParams params;
    private GestureDetector gestureDetector;
    private boolean pd;
    private Double LONG = null, LAT = null;
    private LocationListener listener;
    private LocationManager lm;
    SharedPreferences sp;
    int nou;


    private int status = 0;


    @Override
    public IBinder onBind(Intent intent) {
        return null;


    }


    @Override
    public void onCreate() {
        super.onCreate();

        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext()) ;
        handler = new Handler();
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        //taking display heigth and width
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        winHeight = metrics.heightPixels;
        winWidth = metrics.widthPixels;

        Parent = new RelativeLayout(this);


        button = new ImageView(this);
        button.setImageResource(R.drawable.whiteface);
        gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        button.setOnTouchListener(this);
        button.setPadding(35, 35, 35, 35);

        shape = new GradientDrawable();
        shape.setCornerRadius(20);
        shape.setStroke(5, getResources().getColor(R.color.white));
        shape.setColor(getResources().getColor(R.color.colorPrimary));

        shape2 = new GradientDrawable();
        shape2.setCornerRadius(20);
        shape2.setColor(getResources().getColor(R.color.yellow));
        shape2.setStroke(5, getResources().getColor(R.color.white));
        Parent.setBackground(shape2);

        Parent.setBackground(shape);


        final RelativeLayout.LayoutParams params_buttons = new RelativeLayout.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);


        params_buttons.addRule(RelativeLayout.CENTER_IN_PARENT);


        Parent.addView(button, params_buttons);


        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSPARENT);


        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 200;
        params.y = 100;


        wm.addView(Parent, params);

         nou =sp.getInt("Nou", 0 ) ;


        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new loclistener();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(lm.NETWORK_PROVIDER, 0, 0, listener);



    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (gestureDetector.onTouchEvent(event)) {

            Log.d("Test ", "touch");


            if (status == 2) {


                if (LAT != null && LONG != null && nou != 0) {


                    SmsManager sms = SmsManager.getDefault();
                    for (int i = 1; i <= nou; i++) {


                        String username = sp.getString("Username" + i, "error");
                        String no = sp.getString("Userno" + i, "error");
                        String name = sp.getString("name", "dash");


                      //  sms.sendTextMessage(no, null, username + "Your friend" + name + "urgently needs help .  His/Her \n LAT : " + LAT + " \n LONG :" + LONG, null, null);

                    }
                } else {

                    Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
                    Log.e("n", nou + "");
                }


                status = 0;

                Parent.setBackground(shape2);
                Log.d("Status", status + "");


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Parent.setBackground(shape);

                    }
                }, 6000);
            } else {

                if (status == 0) {
                    status++;

                    Toast.makeText(this, "Tap 2 More Times for safety ", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (status != 0) {
                                status = 0;

                                Log.d("Restart Status", status + "");
                            }
                        }
                    }, 4 * 1000);


                    Log.d("Status", status + "");
                } else {
                    status++;
                    int mag = 3 - status;
                    Toast.makeText(this, "Tap" + mag + "More Times for safety ", Toast.LENGTH_SHORT).show();
                    Log.d("Status", status + "");


                }


            }
            return true;

        } else {

            switch (event.getAction()) {


                case MotionEvent.ACTION_DOWN:
                    initialX = params.x;
                    initialY = params.y;
                    initialTouchX = event.getRawX();
                    initialTouchY = event.getRawY();
                    return true;
                case MotionEvent.ACTION_UP:
                    return true;
                case MotionEvent.ACTION_MOVE:
                    params.x = initialX + (int) (event.getRawX() - initialTouchX);
                    params.y = initialY + (int) (event.getRawY() - initialTouchY);
                    wm.updateViewLayout(Parent, params);
                    return true;
            }

            Log.d("TesT : ", "TOUCH");

        }

        return false;


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Parent != null) wm.removeView(Parent);

    }


    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;

        }
    }


    public class loclistener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            LONG = location.getLongitude();
            LAT = location.getLatitude();


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }


    }

}





