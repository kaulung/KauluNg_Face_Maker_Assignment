package com.example.face_maker;

/*

Author: Kaulu Ng
Date 9/10/20

 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Face{

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();

    //Constructor for a Face object
    public Face(){
        skinColor = randomize(250);
        eyeColor = randomize(250);
        hairColor = randomize(250);
        hairStyle = randomize(3);
        facePaint.setColor(skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
    }

    public Face(int skinC, int eyeC, int hairC, int hairS){
        skinColor = skinC;
        eyeColor = eyeC;
        hairColor = hairC;
        hairStyle = hairS;

    }

    //Method to generate random numbers
    public int randomize(int range){
        int n = 0;
        n = (int)(Math.random()*range);
        return n;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onDraw(Canvas c){
        c.drawOval(10.0f, 10.0f, 50.0f, 70.0f, facePaint);
        c.drawCircle(20.0f, 30.0f, 10.0f, eyePaint);
        c.drawCircle(40.0f, 30.0f, 10.0f, eyePaint);
        drawHair(c);
    }

    public void drawHair(Canvas canvas){

    }

}
