package br.senac.go.projetoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdicionarAbastecimentoView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento_view);

        Button bt = findViewById(R.id.bt_salvar);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AdicionarAbastecimentoView.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Abastecimento registrado com sucesso", Toast.LENGTH_LONG).show();

            }
        });
    }

}
