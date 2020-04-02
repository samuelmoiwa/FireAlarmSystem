package com.company;

import java.util.*;

/**
 *@author Christos Brentas, A.M: 4442, username: cse84442, email: cbrentas@gmail.com
 */

public class TempSensor {
    private int t=0;
    private int temperature = 0;
    private double tempreliability = 0;
    private int code;

    public TempSensor (int temperature, int t, int code, double tempreliability){
        this.temperature = temperature;
        this.t = t;
        this.code = code;
        this.tempreliability = tempreliability;
    }

    public TempSensor(){

    }

    public int getTempCode(){
        return code;
    }

    public void setTempCode(int temp) {
        code = temp + 19216800;
    }

    public TempSensor(TempSensor other){
        other.temperature = this.temperature;
        other.t = this.t;
        other.tempreliability = this.tempreliability;

    }

    public int getTempTime(){
        return t;
    }

    public void setTempTime(int t){
        this.t = t;
    }

    public int getTemp(){
        return temperature;
    }
    public void computeTemp(){
        Random rand = new Random();
        temperature = rand.nextInt(51);
    }
    public double getReliabilityTemp(){
        return tempreliability = Math.exp(-(Math.pow(10,-3)) * t);
    }

    public  String toString(){
        return("Temperature: " + temperature + " Reliability of temperature Sensor: " + this.getReliabilityTemp());
    }

    public boolean equals(TempSensor allos){
        if(this.t == allos.t && this.temperature == allos.temperature && this.tempreliability == allos.tempreliability){
            return true;
        }
        else
            return false;
    }


}

