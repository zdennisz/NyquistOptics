package com.shir.nyquistoptics.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.shir.nyquistoptics.model.Fov;
import com.shir.nyquistoptics.model.LinePair;
import com.shir.nyquistoptics.model.Sensor;
import com.shir.nyquistoptics.model.SensorSize;
import com.shir.nyquistoptics.model.Target;
import com.shir.nyquistoptics.model.TargetSize;
import com.shir.nyquistoptics.model.TargetSizeHolder;

public class DB {

    //------------------------------------- Singleton ------------------------------------------
    private static DB instance = null;

    private DB() {
    }

    public static DB getGameControl() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    //-------------------------------- Calculation Parameters -------------------------------------


    private boolean inputHfov;
    private boolean inputFocal;

    private Fov fov;

    private LinePair linePair;

    private Sensor sensor;
    private SensorSize SensorSize;

    private Target natoTarget;
    private Target humanTarget;
    private Target objectTarget;

    private TargetSize natoTargetSize;
    private TargetSize humanTargetSize;
    private TargetSize objectTargetSize;

    //-------------------------------- Calculation Methods -------------------------------------



    public void initInputParams (double sensorPitch, double sensorSizeW, double sensorSizeH){

        // Init FOV & Sensor from user input
        initFovParams ();
        initSensorParams (sensorPitch, sensorSizeW, sensorSizeH);

        // Init line pairs & target size from shared preference
        initLinePairParams ();
        initTargetSizeParams ();


    }

    public void initFovParams (){

        this.fov = new Fov();
    }

    public void initSensorParams (double sensorPitch, double sensorSizeW, double sensorSizeH){

        this.sensor = new Sensor(sensorPitch, sensorSizeW, sensorSizeH);
    }

    public void initLinePairParams (){

        this.fov = new Fov();
    }

    public void initTargetSizeParams (){

        this.fov = new Fov();
    }

}
