package com.example.admin.sentvalues;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String text,text2,text3,text4 ;
    Spinner spinnerCountry ;
    String countryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        //button.setOnHoverListener();
        //SharePreferences จะอยู่ตลอด จนกว่าจะลบแอพ ไม่เก็บอะไรยาว ๆ
        SharedPreferences sharedPreferences = getSharedPreferences("save", Context.MODE_PRIVATE);
        // SharePrefer have หลาย Mode  public private ... And Context = doc

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","Elena");
        editor.putInt("idName",12);
        editor.commit(); //

        spinnerCountry = (Spinner) findViewById(R.id.spinner_country);  // id in xml

        final String[] countries = getResources().getStringArray((R.array.country_arrays)); // tag xml is array
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>  // <String> = type in arrayAdapter เอาใส่ เพื่อนเปลี่ยนสตริงเป็น ไอเทม
                (this, android.R.layout.simple_dropdown_item_1line, countries);
        spinnerCountry.setAdapter(adapterCountry);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position /*ตำแหน่งที่กดๅ*/, long id) {
                // click select
              //  Toast.makeText(/*MainActivity.this */ getApplicationContext(), countries[position], Toast.LENGTH_LONG).show(); // Alert and hide slow
                        countryName = countries[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //click not select บังคับมี
            }
        });

        button.setOnClickListener(  new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    // To do
                   EditText editText = (EditText) findViewById(R.id.editText);
                    text = editText.getText().toString();

                    EditText editText2 = (EditText) findViewById(R.id.editText2);
                    text2 = editText2.getText().toString();

                    EditText editText3 = (EditText) findViewById(R.id.editText3);
                    text3 = editText3.getText().toString();

                    EditText editText4 = (EditText) findViewById(R.id.editText4);
                    text4 = editText4.getText().toString();

                   //countryName = spinnerCountry.getSelectedItem().toString();

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    //Intent intent12 = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("GPAX",text);
                    intent.putExtra("Firstname",text2);
                    intent.putExtra("Lastname",text3);
                    intent.putExtra("YEAR" , text4);
                    intent.putExtra("country" , countryName);

                    startActivity(intent);
                }
            }
        );
    }

    public  void  sendData(View view){
       /* EditText editText = (EditText) findViewById(R.id.editText);
        text = editText.getText().toString();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("name",text);*/

        EditText editText = (EditText) findViewById(R.id.editText);
        text = editText.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        text2 = editText2.getText().toString();

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        text3 = editText3.getText().toString();

        EditText editText4 = (EditText) findViewById(R.id.editText4);
        text4 = editText4.getText().toString();


        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        //Intent intent12 = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("name",text);
        intent.putExtra("name2",text2);
        intent.putExtra("name3",text3);
        intent.putExtra("name4" , text4);
        startActivity(intent);

    }
}
