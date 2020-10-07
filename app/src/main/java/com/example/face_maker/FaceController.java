package com.example.face_maker;

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

    //Constructor of a FaceController needs a face object to control
    public FaceController(Face f){ this.currFace = f;}

    @Override
    public void onClick(View view) {
        currFace.randomize();
        currFace.invalidate();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int uniqueID) {
        //Use the uniqueID to find the radio button and set it to buttonSelected;
        buttonSelected = radioGroup.indexOfChild(radioGroup.findViewById(uniqueID));

        currFace.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Checks to see which SeekBar is being changed and modify the Face accordingly
        int specificSeek = seekBar.getId();

        if(specificSeek == R.id.seekRed){
            redAmount = seekBar.getProgress();
        }
        else if(specificSeek == R.id.seekGreen){
            greenAmount = seekBar.getProgress();
        }
        else if(specificSeek == R.id.seekBlue){
            blueAmount = seekBar.getProgress();
        }

        //Checking to see which radio button is selected if any is and
        //Change the specific feature of the face accordingly
        if(buttonSelected == 0){
            currFace.setHairColor(redAmount,greenAmount,blueAmount);
        }
        else if(buttonSelected == 1){
            currFace.setEyeColor(redAmount,greenAmount,blueAmount);
        }
        else if(buttonSelected == 2 ){
            currFace.setSkinColor(redAmount,greenAmount,blueAmount);
        }

        //Redraw the face after things have been changed
        currFace.invalidate();
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
