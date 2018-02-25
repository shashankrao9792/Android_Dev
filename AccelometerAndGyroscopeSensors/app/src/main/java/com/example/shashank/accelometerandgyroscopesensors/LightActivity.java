package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class LightActivity extends Activity {

    private SensorManager lSensorManager;
    private Sensor sensor;
    String accuracyMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        lSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = lSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(sensor == null){
            Log.e("Light Activity", "Light Sensor not found");
            Toast.makeText(this, "Light Sensor not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        lSensorManager.registerListener(mySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                TextView textView = (TextView) findViewById(R.id.light_text2);
                textView.setText(String.valueOf(event.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            switch(accuracy){
                case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                    accuracyMsg = "Sensor has high accuracy";
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                    accuracyMsg = "Sensor has medium accuracy";
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                    accuracyMsg = "Sensor has low accuracy";
                    break;
                case SensorManager.SENSOR_STATUS_UNRELIABLE:
                    accuracyMsg = "Sensor has unreliable accuracy";
                    break;
                default:
                    break;
            }
            Toast.makeText(LightActivity.this, accuracyMsg, Toast.LENGTH_SHORT).show();
        }
    };

    protected void onPause(){
        super.onPause();
        lSensorManager.unregisterListener(mySensorEventListener);
    }
}
