package br.com.codepampa.experimento_um;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_dashboard);

        removerNotificacaoClickada();

        removerTodasNotificacoes();
    }

    private void removerNotificacaoClickada() {
        findViewById(R.id.bt_cancelarNotificacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.cancel(1);
            }
        });
    }

    private void removerTodasNotificacoes() {
        findViewById(R.id.bt_cancelarTodas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.cancelAll();
            }
        });
    }
}
