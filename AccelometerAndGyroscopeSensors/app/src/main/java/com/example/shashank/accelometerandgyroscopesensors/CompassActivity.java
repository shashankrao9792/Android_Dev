package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CompassActivity extends Activity {

    private static SensorManager cSensorManager;
    private MyCompassView compassView;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compassView = new MyCompassView(this);
        setContentView(compassView);

        cSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = cSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if(sensor == null){
            Log.e("Compass MainActivity", "ORIENTATION Sensor not found");
            Toast.makeText(this, "ORIENTATION Sensor not found", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float azimuth = event.values[0];
            compassView.updateData(azimuth);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume(){
        super.onResume();
        cSensorManager.registerListener(mySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(sensor != null){
            cSensorManager.unregisterListener(mySensorEventListener);
        }
    }
}
