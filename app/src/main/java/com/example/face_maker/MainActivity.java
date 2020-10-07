package com.example.face_maker;
/*

Author: Kaulu Ng
Date 9/10/20

 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize a face to be controlled
        Face mainFace = findViewById(R.id.faceSurfaceView);

        //initializing seekBars
        SeekBar redSeek = findViewById(R.id.seekRed);
        SeekBar greenSeek = findViewById(R.id.seekGreen);
        SeekBar blueSeek = findViewById(R.id.seekBlue);

        //initialize controller for the face
        FaceController mainController = new FaceController(mainFace, redSeek, greenSeek, blueSeek);

        //initializing random face button
        Button randButton = findViewById(R.id.random_button);
        randButton.setOnClickListener(mainController);

        //Initializing RadioGroup
        RadioGroup buttonGroup = findViewById(R.id.radio_butts);
        buttonGroup.setOnCheckedChangeListener(mainController);

        //Setting the listener of the seekBars to mainController
        redSeek.setOnSeekBarChangeListener(mainController);
        greenSeek.setOnSeekBarChangeListener(mainController);
        blueSeek.setOnSeekBarChangeListener(mainController);

        //Initalizing the spinner and setting the controller
        Spinner hair_spinner = findViewById(R.id.spinner_hair);
        hair_spinner.setOnItemSelectedListener(mainController);
    }


}