package com.cyberwalker.fashionstore

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "notification_channel"
const val channelName ="com.cyberwalker.fashionstore"

class MyFirebaseMessagingService: FirebaseMessagingService() {
    // 1. Generate Notification
    // 2. Attach the notification created with the custom layout
    // 3. Show notification


    //3
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.getNotification() != null){
            generateNotification(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)
        }
    }


    //2
    fun getRemoteView(title: String, message: String): RemoteViews{
        // Remote Views needs package name as an argument, used channelName
        val remoteView = RemoteViews(channelName, R.layout.notification)

        remoteView.setTextViewText(R.id.notification_title, title)
        remoteView.setTextViewText(R.id.notification_message, message)
        remoteView.setImageViewResource(R.id.app_logo, R.drawable.ic_launcher_foreground)

        return remoteView
    }


    //1
    fun generateNotification(title: String, message: String){

        val intent = Intent(this, MainActivity::class.java)
        // clears stack and add message to the top
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        // used when we need for future
        // Flag one shot means we are using this pending activiyt just once
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        // channel id, channel name
        // makes notif more concise and clear

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,
            channelId
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
                // time in milliseconds, (vibrate, relax)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title, message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // checks the client's version to make sure they have the correct features

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(notificationChannel)

        }

        notificationManager.notify(0,builder.build())







    }
}