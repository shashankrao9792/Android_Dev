package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AccelActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private boolean color = false;
    private View view;
    private long lastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);

        view = findViewById(R.id.accel_text1);
        view.setBackgroundColor(Color.GREEN);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getAccelometer(event);
        }
    }

    private void getAccelometer(SensorEvent event){
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];

        TextView t1 = (TextView) findViewById(R.id.accel_text2);
        TextView t2 = (TextView) findViewById(R.id.accel_text3);
        TextView t3 = (TextView) findViewById(R.id.accel_text4);

        String s1 = "X Value = "+String.valueOf(x);
        String s2 = "Y Value = "+String.valueOf(y);
        String s3 = "Z Value = "+String.valueOf(z);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);

        float accelSquareRoot = (x*x + y*y + z*z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if(accelSquareRoot >= 2){
            if(actualTime-lastUpdate < 200){
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT).show();
            if(color){
                view.setBackgroundColor(Color.GREEN);
            }
            else{
                view.setBackgroundColor(Color.RED);
            }
            color = !color;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
