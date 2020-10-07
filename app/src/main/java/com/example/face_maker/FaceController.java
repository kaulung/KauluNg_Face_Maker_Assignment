package com.example.face_maker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements Spinner.OnItemSelectedListener, View.OnClickListener,
        SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, RadioButton.OnCheckedChangeListener {

    private Face currFace;
    private int redAmount;
    private int greenAmount;
    private int blueAmount;
    private int buttonSelected;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

    //Constructor of a FaceController needs a face object to control
    public FaceController(Face f, SeekBar r, SeekBar g, SeekBar b){
        this.redBar = r;
        this.greenBar = g;
        this.blueBar = b;
        this.currFace = f;
    }

    //Method to listen for a press of the random button
    @Override
    public void onClick(View view) {
        currFace.randomize();
        currFace.invalidate();
    }

    //
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int uniqueID) {
        //Use the uniqueID to find the radio button and set it to buttonSelected;
        buttonSelected = radioGroup.indexOfChild(radioGroup.findViewById(uniqueID));
        currFace.invalidate();

        if(uniqueID == R.id.hairButton_0){
            redBar.setProgress(Color.red(currFace.getHairColor()));
            greenBar.setProgress(Color.green(currFace.getHairColor()));
            blueBar.setProgress(Color.green(currFace.getHairColor()));
        }
        else if(uniqueID == R.id.eyeButton_1){
            redBar.setProgress(Color.red(currFace.getEyeColor()));
            greenBar.setProgress(Color.green(currFace.getEyeColor()));
            blueBar.setProgress(Color.green(currFace.getEyeColor()));
        }
        else if(uniqueID == R.id.skinButton_2){
            redBar.setProgress(Color.red(currFace.getSkinColor()));
            greenBar.setProgress(Color.green(currFace.getSkinColor()));
            blueBar.setProgress(Color.blue(currFace.getSkinColor()));
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //Only change the values of the seek bar if the user changed it 
        if(b) {
            //Checks to see which SeekBar is being changed and modify the Face accordingly
            int specificSeek = seekBar.getId();

            if (specificSeek == R.id.seekRed) {
                redAmount = redBar.getProgress();
            } else if (specificSeek == R.id.seekGreen) {
                greenAmount = greenBar.getProgress();
            } else if (specificSeek == R.id.seekBlue) {
                blueAmount = blueBar.getProgress();
            }

            //Checking to see which radio button is selected if any is and
            //Change the specific feature of the face accordingly
            if (buttonSelected == 0) {
                currFace.setHairColor(redAmount, greenAmount, blueAmount);
            } else if (buttonSelected == 1) {
                currFace.setEyeColor(redAmount, greenAmount, blueAmount);
            } else if (buttonSelected == 2) {
                currFace.setSkinColor(redAmount, greenAmount, blueAmount);
            }

            //Redraw the face after things have been changed
            currFace.invalidate();
        }
    }

    //Sets the value for the hair style depending on the selection of the button
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        currFace.setHairStyle(i);
        currFace.invalidate();
    }


    //These methods do nothing and aren't used
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
    }
}
