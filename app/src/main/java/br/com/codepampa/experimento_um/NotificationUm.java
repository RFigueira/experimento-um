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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;



public class NotificationUm extends AppCompatActivity implements NotificationInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento_um);
    }

    public void geraNotificacao(View v) {

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, Dashboard.class), 0);

        NotificationCompat.Builder builder = getNotificationBuilder(p);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] descs = new String[]{"Descrição notification 1.", "notification 1.", "notification 1."};

        for(int i=0; i < descs.length; i++) {
            inboxStyle.addLine(descs[i]);
        }
        builder.setStyle(inboxStyle);

        Notification n = builder.build();
        n.vibrate = new long[]{150,300,150,600};

        nm.notify(1, n);

        Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone toque = RingtoneManager.getRingtone(this,som);
        toque.play();
    }

    @NonNull
    private NotificationCompat.Builder getNotificationBuilder(PendingIntent p) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker(getResources().getText(R.string.ticker_notificacao));
        builder.setContentTitle(getResources().getText(R.string.titulo_notificacao));
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(p);
        builder.setColor(Color.GREEN);
        builder.setAutoCancel(false);
        return builder;
    }
}
