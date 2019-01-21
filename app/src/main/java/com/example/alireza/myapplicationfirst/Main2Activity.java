package com.example.alireza.myapplicationfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button b;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b = (Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.testEdit);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                Toast.makeText(getApplicationContext(), text.getText().toString(), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
