package br.senac.go.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaVeiculosView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos_view);
        FloatingActionButton floatingActionButton = findViewById(R.id.fb);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AdicionarVeiculosView.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "tela de registro  de veiculo", Toast.LENGTH_LONG).show();

            }
        });
    }

}
