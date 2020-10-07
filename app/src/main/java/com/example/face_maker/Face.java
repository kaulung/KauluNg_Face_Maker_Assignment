package com.example.face_maker;

/*

Author: Kaulu Ng
Date 9/10/20

 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

//This enabled me to use the method drawOval
import androidx.annotation.RequiresApi;

public class Face extends SurfaceView {

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int mouthColor;
    private int hairStyle;
    private Paint featurePaint = new Paint();

    //Constructor for a Face object, sets the surface view to be drawn on
    public Face(Context context, AttributeSet att   ){
        super(context,att);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        randomize();
    }

    //Setting (int)skinColor to a RGB value using the Color.rgb() method
    public void setSkinColor(int red, int green, int blue) {
        this.skinColor = Color.rgb(red, green, blue);
    }

    //Setting (int)eyeColor to a RGB value using the Color.rgb() method
    public void setEyeColor(int red, int green, int blue){
        this.eyeColor = Color.rgb(red, green, blue);
    }

    //Setting (int)harColor to a RGB value using the Color.rgb() method
    public void setHairColor(int red, int green, int blue){
        this.hairColor = Color.rgb(red, green, blue);
    }

    //Setting (int)mouthColor to a RGB value using the Color.rgb() method
    public void setMouthColor(int red, int green, int blue){
        this.mouthColor = Color.rgb(red,green,blue);
    }

    //getter method for the hairColor variable
    public int getHairColor() {
        return this.hairColor;
    }

    //getter method for the eyeColor variable
    public int getEyeColor(){
        return this.eyeColor;
    }

    //gettermethod for the skinColor
    public int getSkinColor(){
        return this.skinColor;
    }
    

    //Method to randomly set the colors of the skin, eyes, hair, and mouth using Math.random()
    public void randomize(){

        setSkinColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        setEyeColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        setHairColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        setMouthColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        this.hairStyle = (int)(Math.random()*3);
    }

    //Setter method of hairStyle
    public void setHairStyle(int i){
        this.hairStyle = i;
    }

    public void drawFace(Canvas c){
        //Draw face with color, skinColor
        featurePaint.setColor(skinColor);
        featurePaint.setStyle(Paint.Style.FILL);
        c.drawCircle(500.0f, 500.0f, 300.0f, featurePaint);
    }

    public void drawEyes(Canvas c){
        //Draw dumb eyes with the color, eyeColor
        Paint whiteEye = new Paint();
        whiteEye.setColor(Color.WHITE);
        whiteEye.setStyle(Paint.Style.FILL);
        featurePaint.setColor(eyeColor);
        featurePaint.setStyle(Paint.Style.FILL);
        c.drawCircle(400.0f, 325.0f, 50.0f, whiteEye);
        c.drawCircle(375.0f, 325.0f, 25.0f, featurePaint);
        c.drawCircle(600.0f, 325.0f, 50.0f, whiteEye);
        c.drawCircle(625.0f, 325.0f, 25.0f, featurePaint);
    }

    public void drawMouth(Canvas c){
        //Draw mouth with the color, mouthColor
        featurePaint.setColor(mouthColor);
        featurePaint.setStyle(Paint.Style.FILL);
        c.drawRect(300.0f, 500.0f, 700.0f, 550.0f, featurePaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas c){
        featurePaint.setColor(hairColor);
        featurePaint.setStyle(Paint.Style.FILL);

        //Draw hair style depending on the button that was selected
        if(hairStyle == 0){
            c.drawOval(350.0f, 100.0f, 650.0f, 200.0f, featurePaint);
            c.drawRect(350.0f, 150.0f, 650.0f, 250.0f,featurePaint);
        }
        else if(hairStyle == 1){
            c.drawOval(400.0f, 100.0f, 600.0f, 300.0f, featurePaint);
        }
        else if(hairStyle == 2){
            c.drawRect(450.0f, 50.0f, 550.0f, 250.0f,featurePaint);
        }

    }
    //Draws the entire face with all features
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @ Override
    public void onDraw(Canvas c){
        //Call drawFace method, which draws the face
        drawFace(c);
        //Call drawEyes method, which draws the eyes
        drawEyes(c);
        //Call drawMouth method, which draws the mouth
        drawMouth(c);
        //Call drawHair method, which draws the hair
        drawHair(c);
    }



}
