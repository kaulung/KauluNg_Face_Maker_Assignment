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

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();


    //Constructor for a Face object
    public Face(Context context, AttributeSet att   ){
        super(context,att);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        skinColor = randomize(25);
        eyeColor = randomize(25);
        hairColor = randomize(25);
        hairStyle = randomize(3);

    }

    //Method to generate random numbers
    public int randomize(int range){
        int n = 0;
        n = (int)(Math.random()*range);
        return n;
    }

    @ Override
    public void onDraw(Canvas c){
        facePaint.setColor(skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        c.drawCircle(50.0f, 50.0f, 50.0f, facePaint);
        c.drawCircle(20.0f, 30.0f, 10.0f, eyePaint);
        c.drawCircle(40.0f, 30.0f, 10.0f, eyePaint);
        drawHair(c);
    }

    public void drawHair(Canvas canvas){

    }

}
