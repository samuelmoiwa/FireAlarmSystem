package com.company;

import java.util.Random;


/**
 *@author Christos Brentas, A.M: 4442, username: cse84442, email: cbrentas@gmail.com
 */

public class BrightSensor {
    private int t = 0;
    private double brightness = 0;
    private double brightreliability = 0;
    private int code;

    public BrightSensor(){

    }

    public BrightSensor (int temperature, int t, int code, double brightreliability){
        this.brightness = temperature;
        this.t = t;
        this.code = code;
        this.brightreliability = brightreliability;
    }

    public BrightSensor(BrightSensor other){
        other.brightness = this.brightness;
        other.t = this.t;
        other.brightreliability = this.brightreliability;
    }

    public int getBrightCode(){
        return code;
    }

    public void setBrightCode(int temp) {
        code = temp + 19216800;
    }

    public int getBrightTime(){
        return t;
    }

    public void setBrightTime(int t){
        this.t = t;
    }

    public double getBright(){
        return brightness;
    }
    public void computeBright(){
        Random r = new Random();
        brightness = 200 * r.nextDouble();
    }
    public double getReliabilityBright(){
        return brightreliability = Math.exp(-(Math.pow(10,-3)) * t);
    }

    public  String toString(){
        return("Brightness: " + brightness + " Reliability of brightness Sensor: " + this.getReliabilityBright());
    }

    public boolean equals(BrightSensor allos){
        if(this.t == allos.t && this.brightness == allos.brightness && this.brightreliability == allos.brightreliability){
            return true;
        }
        else
            return false;
    }
}