package com.example.kranthi.notifications;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Notification notification;
    NotificationManager nm;
    EditText editText, editText2;
    String alert, alert2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = (Button) findViewById(R.id.btn1);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shownotification();
            }
        });
        Button clear =(Button) findViewById(R.id.btn2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearnotification();
            }
        });

    }

    public void shownotification(){
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        alert = editText.getText().toString();
        alert2 = editText2.getText().toString();
        Intent intent = new Intent();
       //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        Intent intent1 = new Intent();
        intent1.setAction(Intent.ACTION_DIAL);
        intent1.setData(Uri.parse("tel:9676015679"));
        Intent intent2 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(intent2, 0);
        //intent2.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

        PendingIntent pendingintent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);
        PendingIntent pendingintent1 = PendingIntent.getActivity(getApplicationContext(),2, intent1, 0);
        PendingIntent pendingintent2 = PendingIntent.getActivity(getApplicationContext(), 3, intent2, 0);
        //Notification.Action action = (android.R.drawable.sym_action_call,"dail", pendingintent1);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle(alert)
                .setContentText(alert2)
                .setContentIntent(pendingintent)
                .addAction(android.R.drawable.sym_action_call,"CALL", pendingintent1)
                .addAction(android.R.drawable.ic_menu_camera,"CAMERA", pendingintent2)
                .setSmallIcon(R.drawable.kranthi)
                .build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,notification);
         /*nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
         notification = new Notification(R.drawable.kranthi,"custom notification",System.currentTimeMillis());
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(false);
        builder.setTicker("this is a ticker message");
        builder.setContentTitle("this notification tester");
        builder.setContentText("hi you have new notification");
        builder.setSmallIcon(R.drawable.kranthi);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
       *//* builder.setNumber(100);*//*
        notification = builder.getNotification();
        nm.notify(0,notification);
*/
    }
    public void clearnotification(){
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(1);


    }
}
