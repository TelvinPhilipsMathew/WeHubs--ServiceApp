package com.wehubs.weservice.screens;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.Window;

import com.wehubs.weservice.R;
import com.wehubs.weservice.screens.getStarted.GetStarted;

public class Splash extends Activity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

        launchHandler(3000);

        // sendNotification("Sample ,,,,,,");
    }

    private void sendNotification(String msg) {
        NotificationManager mNotificationManager;
        NotificationCompat.Builder builder;
        Context ctx;
        mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(this, Splash.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
//        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
//                new Intent(ctx, Splash.class), 0);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_menu_gallery)
                        .setLargeIcon(image)
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                        .setContentTitle("SoCXO")
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(1, mBuilder.build());
    }

    private void launchHandler(int time) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextScreen();
            }
        }, time);
    }

    private void showNextScreen() {
        startActivity(new Intent(Splash.this, GetStarted.class));
    }
}

