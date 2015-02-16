package com.coen268.nishant.hw4v20;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Nishant on 2/15/2015.
 */
public class MyIntentService extends IntentService {
    MediaPlayer playermusic;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        playermusic = MediaPlayer.create(MyIntentService.this,R.raw.eraser);
        playermusic.start();
    }
}
