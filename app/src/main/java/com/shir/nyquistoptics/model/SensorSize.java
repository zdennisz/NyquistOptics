package com.shir.nyquistoptics.model;

/**
 * This class contains the user input sensor size (static class).
 */
public class SensorSize {

    //------------------------------------- Constructor -------------------------------------

    protected SensorSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //------------------------------------- Parameters -------------------------------------

    /**
     * The user input value of sensor size - width.
     */
    private double width;

    /**
     * The user input value of sensor size - height.
     */
    private double height;


    //------------------------------------- Getters & Setters -------------------------------------

    /**
     * Setter for width.
     * @return = The user input value of sensor size - width.
     */
    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


}
