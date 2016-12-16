package com.example.inbkamath.videostream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VideoStreamActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_stream);
        button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent myIntent = new Intent(VideoStreamActivity.this,Show.class);
                startActivity(myIntent);
            }
        }
        );

        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent myIntent = new Intent(VideoStreamActivity.this,HLSLive.class);
                startActivity(myIntent);
            }
        }
        );




    }

}
