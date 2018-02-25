package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TempActivity extends Activity {

    private SensorManager tSensorManager;
    private Sensor sensor;
    String accuracyMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        tSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = tSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(sensor == null){
            Log.e("Temperature Activity", "Temperature Sensor not found");
            Toast.makeText(this, "Temperature Sensor not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        tSensorManager.registerListener(mySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
                TextView textView = (TextView) findViewById(R.id.temp_text);
                String s = "Temperature Sensor Reading = "+String.valueOf(event.values[0])+" degree Celsius";
                textView.setText(s);
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
            Toast.makeText(TempActivity.this, accuracyMsg, Toast.LENGTH_SHORT).show();
        }
    };

    protected void onPause(){
        super.onPause();
        tSensorManager.unregisterListener(mySensorEventListener);
    }
}
