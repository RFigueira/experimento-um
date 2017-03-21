package br.com.codepampa.experimento_um;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class NotificationTres extends AppCompatActivity implements NotificationInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento_tres);
    }

    public void geraNotificacao(View v) {

        v.postDelayed(new Runnable() {
            @Override
            public void run() {

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                PendingIntent p = PendingIntent.getActivity(NotificationTres.this, 0, new Intent(NotificationTres.this, Dashboard.class), 0);

                NotificationCompat.Builder buider = new android.support.v7.app.NotificationCompat.Builder(NotificationTres.this);
                buider.setDefaults(Notification.DEFAULT_ALL);
                buider.setContentTitle(getResources().getText(R.string.titulo_notificacao));
                buider.setSmallIcon(R.mipmap.ic_launcher);
                buider.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                buider.setContentIntent(p);
                buider.setAutoCancel(true);

                buider.setColor(Color.BLUE);
                buider.setFullScreenIntent(p,false);
                buider.setVisibility(android.support.v7.app.NotificationCompat.VISIBILITY_PRIVATE);
                buider.setVisibility(android.support.v7.app.NotificationCompat.VISIBILITY_PRIVATE);

                NotificationCompat.InboxStyle inboxStyle = new android.support.v7.app.NotificationCompat.InboxStyle();
                String[] descs = new String[]{"Descricao notification 3.", "notification 3.", "notification 3."};
                for(int i=0; i < descs.length; i++){
                    inboxStyle.addLine(descs[i]);
                }
                buider.setStyle(inboxStyle);

                Notification n = buider.build();
                n.vibrate = new long[]{150,300,150,600};
                n.flags = Notification.FLAG_AUTO_CANCEL;

                nm.notify(R.mipmap.ic_launcher, n);

                Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone toque = RingtoneManager.getRingtone(NotificationTres.this,som);
                toque.play();
            }
        }, 3000);

    }
}
