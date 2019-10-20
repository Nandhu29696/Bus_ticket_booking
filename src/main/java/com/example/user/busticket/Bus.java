package com.example.user.busticket;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Bus extends AppCompatActivity {
   ListView listView;TextView textView;
    ImageView imageView;
    String BusName[]={"SPS travels ","RKR travels","Vj travels"};
    int img[]={R.drawable.bus1, R.drawable.bus2, R.drawable.bus3};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus);
        textView=(TextView)findViewById(R.id.textbs);
        imageView=(ImageView)findViewById(R.id.image);
        listView=(ListView)findViewById(R.id.list_item);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,R.id.list_item,BusName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(Bus.this,Registtr.class);
                startActivity(i);}});}}