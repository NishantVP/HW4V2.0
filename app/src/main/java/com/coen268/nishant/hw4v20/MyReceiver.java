package com.coen268.nishant.hw4v20;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nishant on 2/16/2015.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Toast.makeText(context, "Nishant Broadcast.", Toast.LENGTH_LONG).show();
            Log.d("BROADCAST", "User_Present");

            //intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            int id = 12345;
            int requestCode = 0;
            int flags = 0;
            Intent intent2 = new Intent(context, MainDrawActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    context, requestCode, intent2, flags);


            Notification mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.brush)
                            .setContentTitle("My notification")
                            .setContentText("Hello World!")
                            .setContentIntent(pendingIntent)
                            .build();

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                    Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, mBuilder);
/*
            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(context, MainDrawActivity.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(Context.this);

            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainDrawActivity.class);

            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);

            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            // mId allows you to update the notification later on.
           // mNotificationManager.notify(mId, mBuilder.build());

            /*
            Intent intent1 = new Intent(context, MainDrawActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            */

        }

    }
}
