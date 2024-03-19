package com.project.gradingmanagementsystem;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.project.gradingmanagementsystem.Teacher.ShowNoteActivity;

public class NotificationHelper {
    private static final String CHANNEL_ID = "2023";

    public static void showNotification(ShowNoteActivity context, String title, String description, String fileUri) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(description + "\nFile URI: " + fileUri)
                .setColor(Color.BLUE)
                .setAutoCancel(true);

        // Handle the fileUri (e.g., load the file and include its content in the notification)

        Intent intent = new Intent(context, ShowNoteActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("fileUri", fileUri);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
