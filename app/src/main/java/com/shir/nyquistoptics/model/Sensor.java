package com.shir.nyquistoptics.model;

public class Sensor {


    //------------------------------------- Constructor -------------------------------------


    public Sensor(double sensorPitch, double sensorSizeW, double sensorSizeH) {
        this.sensorPitch = sensorPitch;
        this.sensorSize = new SensorSize(sensorSizeW, sensorSizeH);
    }


    //------------------------------------- Parameters -------------------------------------

    /**
     * The user input value of sensor pitch.
     */
    private double sensorPitch;



    /**
     * The user input value of sensor size.
     */
    private SensorSize sensorSize;


    //------------------------------------- Getters & Setters -------------------------------------

    public double getSensorPitch() {
        return sensorPitch;
    }

    public void setSensorPitch(double sensorPitch) {
        this.sensorPitch = sensorPitch;
    }


    public SensorSize getSensorSize() {
        return sensorSize;
    }

    public void setSensorSize(SensorSize sensorSize) {
        this.sensorSize = sensorSize;
    }

}
