package com.example.user.busticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2; Button b1,b2;
    String user,password;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
         e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=e1.getText().toString();
                String password=e2.getText().toString();
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
                if(password.equals(storedPassword))
                {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,Country.class);
                    startActivity(i);}
                else {Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();}
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,NewUser.class);
                startActivity(i);
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close(); }}
