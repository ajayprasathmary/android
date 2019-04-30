package com.compunetconnections.academy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService

{

    private static final String TAG ="MyFirebaseMsgService";

    @Override

    public void onMessageReceived (RemoteMessage remotemessage)

{

    Log.d(TAG,"From:"+remotemessage.getFrom());
    Log.d(TAG,"Notification Message Body : "   +remotemessage.getNotification().getBody());

    SendNotification(remotemessage.getNotification().getBody());

}

    private void SendNotification(String messagebody)

    {

        Intent in = new Intent(this,MainActivity.class);

        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this,0,in,PendingIntent.FLAG_ONE_SHOT);

        //Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Uri sound = Uri.parse("file:///android_asset/hopo.mp3");

      /* Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
       r.play();*/




        NotificationCompat.Builder notificationBuilder  =  new  NotificationCompat.Builder(this)

                .setSmallIcon(R.drawable.acaaaa)
                .setContentTitle("FIREBASE_NOTIFY")
                .setContentText(messagebody)
                .setSound(sound, AudioManager.STREAM_NOTIFICATION)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                .setContentIntent(pi);

        NotificationManager notificationmanager = (NotificationManager)

                getSystemService(Context.NOTIFICATION_SERVICE);

        notificationmanager.notify(0,notificationBuilder.build());


    }
}

