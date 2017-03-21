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


public class NotificationDois extends AppCompatActivity implements NotificationInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento_dois);
    }

    public void geraNotificacao(View v) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, NotificationDois.class), 0);

        android.support.v7.app.NotificationCompat.Builder buider = new android.support.v7.app.NotificationCompat.Builder(this); //cria um buider de Notificações
        buider.setDefaults(Notification.DEFAULT_ALL); // Ativa configurações padrão
        buider.setContentTitle(getResources().getText(R.string.titulo_notificacao));
        buider.setSmallIcon(R.mipmap.ic_launcher);
        buider.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        buider.setContentIntent(p);
        buider.setAutoCancel(true);
        buider.setColor(Color.BLUE);
        buider.setFullScreenIntent(p,false);
        buider.setVisibility(android.support.v7.app.NotificationCompat.VISIBILITY_PRIVATE);


        NotificationCompat.InboxStyle inboxStyle = new android.support.v7.app.NotificationCompat.InboxStyle();
        String[] descs = new String[]{"Descrição notification 2.", "notification 2.", "notification 2."};
        for(int i=0; i < descs.length; i++){
            inboxStyle.addLine(descs[i]);
        }
        buider.setStyle(inboxStyle);

        Notification n = buider.build();
        n.vibrate = new long[]{150,300,150,600};
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.mipmap.ic_launcher, n);

        Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone toque = RingtoneManager.getRingtone(this,som);
        toque.play();
    }
}
