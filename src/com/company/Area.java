package com.company;

import java.text.DecimalFormat;



public class Area implements Comparable<Area>{
    private BrightSensor sensorFwteinothtas = new BrightSensor();
    private TempSensor sensorThermokrasias = new TempSensor();
    private double totalReliability = 0;
    private int code;
    private int arithmospyrkagias;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public Area(BrightSensor x, TempSensor y, int code, double totalReliability, int arithmospyrkagias){
        this.sensorFwteinothtas = x;
        this.sensorThermokrasias = y;
        this.code = code;
        this.totalReliability = totalReliability;
        this.arithmospyrkagias = arithmospyrkagias;

    }
    @Override
    public int compareTo(Area o) {
        return this.code - o.code;
    }

    public Area(){

    }

    public TempSensor getTempSensor(){
        return sensorThermokrasias;
    }
    public BrightSensor getBrightSensor(){
        return sensorFwteinothtas;
    }

    public Area(Area other){
        other.sensorThermokrasias = this.sensorThermokrasias;
        other.sensorFwteinothtas = this.sensorFwteinothtas;
        other.totalReliability = totalReliability;
        other.arithmospyrkagias = this.arithmospyrkagias;
    }

    public double getTotalReliability(){
        return totalReliability;
    }

    public int getAreaCode(){
        return code;
    }

    public void setAreaCode(int temp){
        code = temp;
    }

    public int getArithmospyrkagias(){
        return arithmospyrkagias;
    }

    public void setArithmospyrkagias(int x){
        arithmospyrkagias = x;
    }

    public void computeReliability(){
        totalReliability = (sensorFwteinothtas.getReliabilityBright() * sensorThermokrasias.getReliabilityTemp());
    }

    public void renewMeasures(){
        sensorFwteinothtas.computeBright();
        sensorThermokrasias.computeTemp();
        sensorThermokrasias.setTempTime(sensorThermokrasias.getTempTime() + 1);
        sensorFwteinothtas.setBrightTime(sensorFwteinothtas.getBrightTime() + 1);
        this.computeReliability();
    }


    public boolean equals(Area allh){
        if(this.sensorFwteinothtas == allh.sensorFwteinothtas && this.sensorThermokrasias == allh.sensorThermokrasias && this.totalReliability == allh.totalReliability)
            return true;
        else
            return false;
    }
    public String toString(){
        return ("Area: " + code + "; Temperature: " + sensorThermokrasias.getTemp() + "; Brightness: " + df2.format(sensorFwteinothtas.getBright()) + "; Time period: " + this.getTempSensor().getTempTime());
    }

}