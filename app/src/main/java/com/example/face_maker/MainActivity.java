package com.example.face_maker;
/*

Author: Kaulu Ng
Date 9/10/20

 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner hair_spinner = findViewById(R.id.spinner_hair);
        ArrayAdapter<CharSequence> spinner_adapter = ArrayAdapter.createFromResource(this, R.array.hair_styles, android.R.layout.simple_spinner_item
        );
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hair_spinner.setAdapter(spinner_adapter);
        hair_spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String display_text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), display_text, Toast.LENGTH_SHORT).show( );
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}