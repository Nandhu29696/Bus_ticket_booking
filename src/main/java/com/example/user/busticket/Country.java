package com.example.user.busticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
public class Country extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button; Spinner sp1, sp2;
    String[] From = {"Cbe", "Cheni", "Thirupr", "Velure"};
    String[] To = {"Cbe", "Cheni", "Thirupr", "Velure"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country);
        button = (Button) findViewById(R.id.button4);
        sp1 = (Spinner) findViewById(R.id.spinner3);
        sp2 = (Spinner) findViewById(R.id.spinner4);
        sp1.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, From);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa);
        sp2.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, To);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(a);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                     String Txt2=sp2.getSelectedItem().toString();
                     String Text=sp1.getSelectedItem().toString();
                     Intent intent=new Intent(Country.this,Booking.class);
                     intent.putExtra("a",Text);
                     intent.putExtra("aa",Txt2);
                     startActivity(intent);
                    }});}
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}
    public void onNothingSelected(AdapterView<?> parent) {}}