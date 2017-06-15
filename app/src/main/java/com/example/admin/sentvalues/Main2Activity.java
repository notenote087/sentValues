package com.example.admin.sentvalues;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        String yourname = sharedPreferences.getString("name", "");


        Intent intent = getIntent();   // get intent send with activity1

        String showText2 = "Lastname :"+intent.getStringExtra("Lastname");
        String showText3 = "YEAR : "+intent.getStringExtra("YEAR");
        String showText4 = "Gpax :"+intent.getStringExtra("GPAX");
        String showText = "Firstname :"+intent.getStringExtra("Firstname");

        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(showText);

        TextView txt2 = (TextView) findViewById(R.id.textView2);
        txt2.setText(showText2);

        TextView txt3 = (TextView) findViewById(R.id.textView3);
        txt3.setText(showText3);

        TextView txt4 = (TextView) findViewById(R.id.textView4);
        txt4.setText(showText4);
    }


}
