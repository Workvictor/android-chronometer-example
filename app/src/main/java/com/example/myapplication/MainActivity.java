package com.example.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

  private Chronometer chronometer;
  private boolean running;
  private long pauseOffset = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    chronometer = findViewById(R.id.chronometer);
    chronometer.setFormat("Time: %s");

  }

  public void startTimer(View view) {
    if(!running) {
      chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
      chronometer.start();
      running = true;
    }
  }

  public void pauseTimer(View view) {
    if(running){
      pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
      chronometer.stop();
      running = false;
    }
  }

  public void resetTimer(View view) {
    pauseOffset = 0;
    chronometer.setBase(SystemClock.elapsedRealtime());
    if(running) {
      chronometer.stop();
      running = false;
    }
  }
}
