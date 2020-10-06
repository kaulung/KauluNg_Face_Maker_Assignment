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
import android.view.SurfaceView;

public class Face extends SurfaceView {

    private int skinColor = 0;
    private int eyeColor = 0;
    private int hairColor = 0;
    private int mouthColor = 0;
    private int hairStyle;
    private Paint featurePaint = new Paint();




    //Constructor for a Face object
    public Face(Context context, AttributeSet att   ){
        super(context,att);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        randomize();
    }

    public void setSkinColor(int red, int green, int blue) {
        skinColor = Color.rgb(red, green, blue);
    }

    public void setEyeColor(int red, int green, int blue){
        eyeColor = Color.rgb(red, green, blue);
    }

    public void setHairColor(int red, int green, int blue){
        hairColor = Color.rgb(red, green, blue);
    }

    public void setMouthColor(int red, int green, int blue){
        mouthColor = Color.rgb(red,green,blue);
    }

    //Method to generate random numbers
    public int randomize(){
        int n = 0;
        n = (int)(Math.random()*10);
        return n;
    }



    public void drawFace(Canvas c){
        featurePaint.setColor(skinColor);
        featurePaint.setStyle(Paint.Style.FILL);
        c.drawCircle(300.0f, 300.0f, 200.0f, featurePaint);
    }

    public void drawEyes(Canvas c){
        featurePaint.setColor(eyeColor);
        featurePaint.setStyle(Paint.Style.FILL);
        c.drawCircle(100.0f, 200.0f, 100.0f, featurePaint);
        c.drawCircle(500.0f, 200.0f, 100.0f, featurePaint);
    }

    public void drawMouth(Canvas c){
        featurePaint.setColor(mouthColor);
        featurePaint.setStyle(Paint.Style.FILL);
    }

    public void drawHair(Canvas c){
        featurePaint.setColor(hairColor);
        featurePaint.setStyle(Paint.Style.FILL);
    }



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
