package com.company;

import java.util.Random;



public class BrightSensor {
    private int t = 0;
    private double brightness = 0;
    private double brightReliability = 0;
    private int code;

    public BrightSensor(){

    }

    public BrightSensor (int temperature, int t, int code, double brightreliability){
        this.brightness = temperature;
        this.t = t;
        this.code = code;
        this.brightReliability = brightreliability;
    }

    public BrightSensor(BrightSensor other){
        other.brightness = this.brightness;
        other.t = this.t;
        other.brightReliability = this.brightReliability;
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
        return brightReliability = Math.exp(-(Math.pow(10,-3)) * t);
    }

    public  String toString(){
        return("Brightness: " + brightness + " Reliability of brightness Sensor: " + this.getReliabilityBright());
    }

    public boolean equals(BrightSensor allos){
        if(this.t == allos.t && this.brightness == allos.brightness && this.brightReliability == allos.brightReliability){
            return true;
        }
        else
            return false;
    }
}