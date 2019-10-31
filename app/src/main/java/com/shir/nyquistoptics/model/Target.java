package com.shir.nyquistoptics.model;

/**
 * This class contains all the detection, recognition & identify (DRI) parameters and their calculations. (static class).
 */
public class Target {

    //------------------------------------- Parameters -------------------------------------

    /**
     * The calculated value of target detection
     */
    private double detection;

    /**
     * The calculated value of target recognition
     */
    private double recognition;

    /**
     * The calculated value of target identify
     */
    private double identify;

    //------------------------------------- Constructors -------------------------------------

    /**
     * Target empty constructor
     */
    public Target() {
    }

    //------------------------------------- Formulas -------------------------------------

    /**
     * Helper method that calculates the value of target detection/recognition/identify.
     * @param sensorPitch = The user input value of sensor pitch.
     * @param focalLength = The user input value of focal length.
     * @param targetSize = The value of the target size (height & width).
     * @param line = The value of the line pair.
     * @return = the calculated value for target detection/recognition/identify (DRI)
     */
    private double calcTarget(double sensorPitch, double focalLength, TargetSize targetSize, double line) {

        double target;

        target = (focalLength / (line * sensorPitch / 1000000)) * (Math.sqrt(targetSize.getHeight() * targetSize.getWidth()) / 1000);

        return target;
    }

    /**
     * Method that returns the calculated value of target detection, by using the helper method calcTarget.
     * @param targetSize = The value of the target size (height & width).
     * @return = The value of target detection.
     */
    private double calcDetection(Sensor sensor, Fov fov, TargetSize targetSize, LinePair linePair) {

        double detection;

        // Calculate detection for object target
        if (targetSize.getHeight() <= 0.5) {
            detection = calcTarget(sensor.getSensorPitch(), fov.getFocalLength(), targetSize, linePair.getLpDetObj());
        }

        // Calculate detection for nato/human targets
        else {
            detection = calcTarget(sensor.getSensorPitch(), fov.getFocalLength(), targetSize, linePair.getLpDet());
        }

        return detection;
    }

    /**
     * Method that returns the calculated value of target recognition, by using the helper method calcTarget.
     * @param targetSize = The value of the target size (height & width).
     * @return = The value of target recognition.
     */
    private double calcRecognition(Sensor sensor, Fov fov, TargetSize targetSize, LinePair linePair) {

        double recognition;

        recognition = calcTarget(sensor.getSensorPitch(), fov.getFocalLength(), targetSize, linePair.getLpRec());

        return recognition;
    }

    /**
     * Method that returns the calculated value of target identify, by using the helper method calcTarget.
     * @param targetSize = The value of the target size (height & width).
     * @return = The value of target identify.
     */
    private double calcIdentify(Sensor sensor, Fov fov, TargetSize targetSize, LinePair linePair) {

        double identify;

        // Calculate identify for object target
        if (targetSize.getHeight() <= 0.5) {
            identify = 0;
        }

        // Calculate identify for nato/human targets
        else {
            identify = calcTarget(sensor.getSensorPitch(), fov.getFocalLength(), targetSize, linePair.getLpIdent());
        }

        return identify;
    }


    //------------------------------------- Calculate Target -------------------------------------

    /**
     * Setter for the parameters: detection, recognition & identify (DRI).
     * @param targetSize = The value of the target size (height & width).
     */
    public void calcTargetResult(Sensor sensor, Fov fov, TargetSize targetSize, LinePair linePair) {

        this.detection = calcDetection(sensor, fov, targetSize, linePair);
        this.recognition = calcRecognition(sensor, fov, targetSize, linePair);
        this.identify = calcIdentify(sensor, fov, targetSize, linePair);

    }



    //------------------------------------- Getters & Setters -------------------------------------

    public double getDetection() {
        return detection;
    }

    public void setDetection(TargetSize targetSize) {

    }

    public double getRecognition() {
        return recognition;
    }

    public void setRecognition(TargetSize targetSize) {
    }

    public double getIdentify() {
        return identify;
    }

    public void setIdentify(TargetSize targetSize) {

    }



}
