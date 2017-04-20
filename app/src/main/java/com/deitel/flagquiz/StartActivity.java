package com.deitel.flagquiz;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class StartActivity extends AppCompatActivity implements View.OnClickListener
{


    private Button buttonPlay;
    private SoundPool soundPool;

    private int play = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);


        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            //Create objects of the 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;
            //create our three fx in memory ready for use
            descriptor = assetManager.openFd("play.mp3");
            play = soundPool.load(descriptor, 0);


        } catch (IOException e)
        {
            //catch exceptions here
        }


    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.buttonPlay:
            Intent m;
            m = new Intent(this, MainActivity.class);
            soundPool.play(play,1,1,0,0,1);
            startActivity(m);

            break;
        }
    }
}
