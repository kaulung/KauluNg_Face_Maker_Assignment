package com.example.face_maker;

public class Face  {

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //Constructor for a Face object
    public Face(){
        skinColor = randomize();
        eyeColor = randomize();
        hairColor = randomize();
        hairStyle = randomize();
    }

    public Face(int skinC, int eyeC, int hairC, int hairS){
        skinColor = skinC;
        eyeColor = eyeC;
        hairColor = hairC;
        hairStyle = hairS;
    }

    //Method to generate random numbers
    public int randomize(){
        int n = 0;
        n = (int)(Math.random()*150);
        return n;
    }

}
