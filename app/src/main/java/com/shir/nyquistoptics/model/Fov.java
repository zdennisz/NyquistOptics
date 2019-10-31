package com.shir.nyquistoptics.model;

/**
 * This class contains all the field of view (FOV) parameters and their calculations (static class).
 */
public class Fov {


    //------------------------------------- Parameters -------------------------------------

    /**
     * The calculated value of instantaneous field of view (IFOV).
     */
    private double ifov;

    /**
     * The calculated value of horizontal field of view (HFOV).
     */
    private double hfov;

    /**
     * The calculated value of vertical field of view (VFOV).
     */
    private double vfov;

    /**
     * The user input value of focal length.
     */
    private double focalLength;

    //------------------------------------- Calculate FOV -------------------------------------

    /**
     * Calculator for the parameters: hfov, ifov, vfov.
     */
    public void calcFovResultWithHfov(double focalLength, Sensor sensor) {

        this.focalLength = focalLength;

        this.hfov = calcHfov(sensor);
        this.ifov = calcIfov(sensor);
        this.vfov = calcVfov(sensor);
    }

    /**
     * Calculator for the parameters: focal length, ifov, vfov.
     */
    public void calcFovResultWithFocalLength(double hfov, Sensor sensor) {

        this.hfov = hfov;

        this.focalLength = calcFocalLength(sensor);
        this.ifov = calcIfov(sensor);
        this.vfov = calcVfov(sensor);
    }

    //------------------------------------- Formulas -------------------------------------

    /**
     * The formula that calculates the value of instantaneous field of view (IFOV).
     * @return = The value of instantaneous field of view (IFOV).
     */
    private double calcIfov(Sensor sensor) {
        double ifov = sensor.getSensorPitch() / (this.focalLength * 1000);
        return ifov;
    }

    /**
     * The formula that calculates the value of horizontal field of view (HFOV).
     * @return = The value of horizontal field of view (HFOV).
     */
    private double calcHfov(Sensor sensor) {
        double hfov = 2 * Math.atan((sensor.getSensorPitch() * sensor.getSensorSize().getWidth()) / (2 * 1000 * this.focalLength)) * 180 / Math.PI;
        return hfov;
    }

    /**
     * The formula that calculates the value of vertical field of view (VFOV).
     * @return = The value of vertical field of view (VFOV).
     */
    private double calcVfov(Sensor sensor) {
        double vfov = this.hfov * (sensor.getSensorSize().getHeight() / sensor.getSensorSize().getWidth());
        return vfov;
    }

    private double calcFocalLength(Sensor sensor) {
        double focalLength = (sensor.getSensorPitch() * sensor.getSensorSize().getWidth()) / (2000 * Math.tan((Math.PI * this.hfov) / 360));
        return focalLength;
    }



    //------------------------------------- Getters & Setters -------------------------------------

    public double getIfov() {
        return ifov;
    }

    public void setIfov(double ifov) {
        this.ifov = ifov;
    }

    public double getHfov() {
        return hfov;
    }

    public void setHfov(double hfov) {
        this.hfov = hfov;
    }

    public double getVfov() {
        return vfov;
    }

    public void setVfov(double vfov) {
        this.vfov = vfov;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }


}
