package sodevan.lafly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Info_father extends AppCompatActivity {
    ListView lv;
    CheckedTextView ctv;
    Button b;
    ArrayList<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_father);
        b= (Button) findViewById(R.id.bt_buy);
        final ArrayList<String> items = getIntent().getStringArrayListExtra("items");
        Log.d("first", items.get(0));
        lv = (ListView) findViewById(R.id.lva);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.store_list, items);
        lv.setItemsCanFocus(false);
        lv.setAdapter(adapter);
        ctv = (CheckedTextView) findViewById(R.id.checkedTextView1);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(Info_father.this, "Order Placed Ma'am", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(getApplicationContext(),Home.class);
        startActivity(i);
        finish();

    }
});
    }
}




