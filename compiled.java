package com.example.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText url;
    Button btnPlay;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = findViewById(R.id.btnPlay);
        url = findViewById(R.id.editTextURL);
        Log.d(TAG, "onCreate: Starting.");

        btnPlay.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Initializing YouTube Player");
            URL = url.getText().toString();
            Intent intent = new Intent(MainActivity.this, ViewScreen.class);
            intent.putExtra("url", URL);
            startActivity(intent);
        });
    }
}

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
