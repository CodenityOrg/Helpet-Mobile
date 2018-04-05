package com.kincodi.helpet.helpetmobile;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.kincodi.helpet.helpetmobile.domain.model.Notification;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.PostActivity;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.StateSharedPreferences;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.UserSharedPreferences;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyAndroidFCMService";

    public MyFirebaseMessagingService() {
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        Map<String,String> data = remoteMessage.getData();

        if(data!=null){

            Notification notification = new Notification();

        }
    }
    private void createNotification(Notification notification) {
        Intent intent = new Intent( this , PostActivity.class );
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Notification",notification);
        PendingIntent resultIntent = PendingIntent.getActivity( this , 0, intent,
                PendingIntent.FLAG_ONE_SHOT);
        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder( this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification Get Pretty")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(notification.getDescription()))
                .setContentText(notification.getDescription())
                .setAutoCancel( true )
                .setSound(notificationSoundURI)
                .setContentIntent(resultIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mNotificationBuilder.build());
        EventBus.getDefault().post(notification);
    }
}
