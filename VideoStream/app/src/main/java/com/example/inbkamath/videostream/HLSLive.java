package com.example.inbkamath.videostream;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by inbkamath on 16-Jul-16.
 */
public class HLSLive extends VideoStreamActivity{
    ProgressDialog pd;
    VideoView view;

    String URL ="http://vevoplaylist-live.hls.adaptive.level3.net/vevo/ch1/appleman.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        view=(VideoView)findViewById(R.id.videoView1);

        pd = new ProgressDialog(HLSLive.this);
        pd.setTitle("Video Streaming Demo");
        pd.setMessage("Buffering...");
        pd.setIndeterminate(false);
        pd.setCancelable(false);
        pd.show();

        try {
            MediaController controller = new MediaController(HLSLive.this);
            controller.setAnchorView(view);
            Uri vid = Uri.parse(URL);
            view.setMediaController(controller);
            view.setVideoURI(vid);
        }
        catch (Exception e)
        {
            Log.e("Error",e.getMessage());
            e.printStackTrace();
        }
        view.requestFocus();
        view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
                view.start();
            }
        });
    }

}
