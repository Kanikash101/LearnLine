package spark.planet.com.learnline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import spark.planet.com.learnline.R;

/**
 * using it for playing youtube video
 * <p>
 * Created by Sony on 1/7/2018.
 */

public class PlayVideo extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    // my personal API KEY using it for playing youTube videos in app
    public static final String API_KEY = "AIzaSyCOMLqATGL5jS_UAp79mBkpzf-lN58y0R0";
    public static String video_id = "";
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video);

        Intent in = getIntent();
        // getting the id of the video
        video_id = in.getStringExtra("video_id");

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeplayerview);

        // initializing youTube player with KEY
        youTubePlayerView.initialize(API_KEY, this);


    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(video_id);
        }

        // show the button that view is full screen
        player.setShowFullscreenButton(true);
        // setting the style if the youtube player as Default one
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult result) {

        // showing toast message in case of error
        Toast.makeText(getApplicationContext(),
                "onInitializationFailure()",
                Toast.LENGTH_LONG).show();
    }

}
