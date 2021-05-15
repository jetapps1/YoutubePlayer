package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ViewScreen extends YouTubeBaseActivity {

    private static final String TAG = "ViewScreen";
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        Log.d(TAG, "Created");
        url = getIntent().getStringExtra("url");
        YouTubePlayerView mYouTubePlayerView = findViewById(R.id.youtubePlayerView);
        mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done Initializing");
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to Initialize");
            }
    });
    }
}