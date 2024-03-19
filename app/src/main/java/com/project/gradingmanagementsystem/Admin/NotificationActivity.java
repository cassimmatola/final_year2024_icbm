package com.project.gradingmanagementsystem.Admin;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.project.gradingmanagementsystem.R;
import com.project.gradingmanagementsystem.Teacher.ShowNoteActivity;

public class NotificationActivity extends AppCompatActivity {

    private EditText editTitle, editDescription;
    private Button uploadButton, select;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        editTitle = findViewById(R.id.editTitle);
        editDescription =findViewById(R.id.editDescription);
        uploadButton =findViewById(R.id.btnUpload);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ContextCompat.checkSelfPermission(NotificationActivity.this,
                    Manifest.permission.POST_NOTIFICATIONS) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(NotificationActivity.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},101);
            }
        }

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notice();
            }
        });
//        select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("*/*");
//                startActivityForResult(intent, FILE_REQUEST_CODE);
//
//            }
//        });


    }

    private void Notice() {

        String title = editTitle.getText().toString();
        String description = editDescription.getText().toString();

        String channelID = "Grading Channel";

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(),channelID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(description)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(getApplicationContext(), ShowNoteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("data1",title);
        intent.putExtra("data2",description);
       // intent.putExtra("data3", selectedFileUri);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0,intent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                     notificationManager.getNotificationChannel(channelID);
            if (notificationChannel == null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelID,description,importance);
                notificationChannel.setLightColor(android.R.color.holo_red_dark);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);


            }
        }
        notificationManager.notify(0, builder.build());

    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            selectedFileUri = data.getData();
//
//
//        }
//    }
}