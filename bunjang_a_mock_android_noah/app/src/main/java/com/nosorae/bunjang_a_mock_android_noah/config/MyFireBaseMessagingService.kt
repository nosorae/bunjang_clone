package com.nosorae.bunjang_a_mock_android_noah.config

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.MainActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivity

class MyFireBaseMessagingService: FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.notification != null) {
            Log.d("FCM Log", "알림 메세지: "+ remoteMessage.notification!!.body.toString())

            val messageBody = remoteMessage.notification!!.body
            val messageTitle = remoteMessage.notification!!.title


            val whichActivity = remoteMessage.data.get("whichAction")

            var intent = Intent(this, MainActivity::class.java)

            if(whichActivity.equals("1")) {
                intent = Intent(this, ItemDetailActivity::class.java)
                val productId = remoteMessage.data.get("itemId")
                Log.d("itemIdPushed", "${productId}")
                if(productId != null) {
                    intent.putExtra("itemId", productId.toInt())
                    Log.d("itemIdPushed", "도달2")
                }
            }





            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val defaultsoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val channelId = "Channel ID"
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.push_logo)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultsoundUri)
                .setContentIntent(pendingIntent)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                val channelName = "Channel Name"
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                val channel =  NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH )
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(0, notificationBuilder.build())
        }


        super.onMessageReceived(remoteMessage)
    }
}