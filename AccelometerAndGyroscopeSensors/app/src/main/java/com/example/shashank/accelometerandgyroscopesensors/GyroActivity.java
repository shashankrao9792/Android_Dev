package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class GyroActivity extends Activity implements SensorEventListener{

    private SensorManager gSensorManager;
    private Sensor gyroscope;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyro);

        view = (TextView) findViewById(R.id.gyro_text1);
        view.setBackgroundColor(Color.BLACK);

        gSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = gSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(gyroscope == null){
            Log.e(TAG, "Gyroscope Sensor Not available");
            Toast.makeText(this, "Gyroscope Sensor Not available", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            doGyroWork(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    private void doGyroWork(SensorEvent event){
        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        TextView t1 = (TextView) findViewById(R.id.gyro_text2);
        TextView t2 = (TextView) findViewById(R.id.gyro_text3);
        TextView t3 = (TextView) findViewById(R.id.gyro_text4);

        String s1 = "X Value = "+String.valueOf(x);
        String s2 = "Y Value = "+String.valueOf(y);
        String s3 = "Z Value = "+String.valueOf(z);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);

        if(values[2] > 0.5f){
            view.setBackgroundColor(Color.BLUE);
        }
        else if(values[2] < -0.5f){
            view.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        gSensorManager.registerListener(this, gSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        gSensorManager.unregisterListener(this);
    }
}
