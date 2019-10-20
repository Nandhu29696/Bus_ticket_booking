package com.example.user.busticket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Registtr extends Activity {
    ListView listView;
    TextView textView;
    ImageView imageView;
    String BusName[]={"SPS travels ","RKR travels","Vj travels"};
    int img[]={R.drawable.bus1, R.drawable.bus2, R.drawable.bus3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
    }

}