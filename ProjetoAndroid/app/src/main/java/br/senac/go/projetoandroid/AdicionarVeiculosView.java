package br.senac.go.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdicionarVeiculosView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_veiculos_view);
        Button bt = findViewById(R.id.bt_salvar);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListaVeiculosView.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "registrado com sucesso", Toast.LENGTH_LONG).show();

            }
        });
    }

}
