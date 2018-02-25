package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class ProximityActivity extends Activity implements SensorEventListener {

    private SensorManager pSensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        pSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = pSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensor == null){
            Log.e(TAG, "Proximity Sensor Not available");
            Toast.makeText(this, "Proximity Sensor Not available", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        pSensorManager.registerListener(this, sensor, 1*1000*1000);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){

            float[] values = event.values;

            float x = values[0];
            float y = values[1];

            TextView t1 = (TextView) findViewById(R.id.proximity_text2);
            TextView t2 = (TextView) findViewById(R.id.proximity_text3);

            String s1 = "X Value = "+String.valueOf(x);
            String s2 = "Y Value = "+String.valueOf(y);

            t1.setText(s1);
            t2.setText(s2);

            TextView textView = findViewById(R.id.proximity_text1);
            if(event.values[0] < sensor.getMaximumRange()){
                textView.setBackgroundColor(Color.CYAN);
            }
            else {
                textView.setBackgroundColor(Color.MAGENTA);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    protected void onPause(){
        super.onPause();
        pSensorManager.unregisterListener(this);
    }
}
