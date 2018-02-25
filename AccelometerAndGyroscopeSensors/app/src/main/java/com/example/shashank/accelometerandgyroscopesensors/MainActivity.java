package com.example.shashank.accelometerandgyroscopesensors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        runAccelSensor();
                        break;
                    case 1:
                        runGyroSensor();
                        break;
                    case 2:
                        runCompass();
                        break;
                    case 3:
                        runTemp();
                        break;
                    case 4:
                        runLight();
                        break;
                    case 5:
                        runPressure();
                        break;
                    case 6:
                        runHumidity();
                        break;
                    case 7:
                        runProximity();
                        break;
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(itemClickListener);
    }

    public void runAccelSensor(){
        Intent intent = new Intent(MainActivity.this, AccelActivity.class);
        startActivity(intent);
    }

    public void runGyroSensor(){
        Intent intent = new Intent(MainActivity.this, GyroActivity.class);
        startActivity(intent);
    }

    public void runCompass(){
        Intent intent = new Intent(MainActivity.this, CompassActivity.class);
        startActivity(intent);
    }

    public void runTemp(){
        Intent intent = new Intent(MainActivity.this, TempActivity.class);
        startActivity(intent);
    }

    public void runLight(){
        Intent intent = new Intent(MainActivity.this, LightActivity.class);
        startActivity(intent);
    }

    public void runPressure(){
        Intent intent = new Intent(MainActivity.this, PressureActivity.class);
        startActivity(intent);
    }

    public void runHumidity(){
        Intent intent = new Intent(MainActivity.this, HumidityActivity.class);
        startActivity(intent);
    }

    public void runProximity(){
        Intent intent = new Intent(MainActivity.this, ProximityActivity.class);
        startActivity(intent);
    }
}
