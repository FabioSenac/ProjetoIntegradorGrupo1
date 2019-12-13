package br.senac.go.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Veiculos;
import br.senac.go.projetoandroid.data.repository.IVeiculoRepository;
import br.senac.go.projetoandroid.data.repository.RepositorioCallback;
import br.senac.go.projetoandroid.data.repository.VeiculoRepository;
import br.senac.go.projetoandroid.data.repository.source.VeiculoApiSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdicionarVeiculosView extends AppCompatActivity {


    private IVeiculoRepository veiculoRepository;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_veiculos_view);
        Button bt = findViewById(R.id.bt_salvar);

        rv = findViewById(R.id.rv);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.1:8081/")
//.baseUrl("http://172.16.1.94:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        VeiculoApiSource veiculoApiSource = retrofit.create(VeiculoApiSource.class);

        Button botao = findViewById(R.id.button);




        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AdicionarVeiculosView.this,  AddVeiculo.class);
                startActivity(it);
                Toast.makeText(getApplicationContext(), "registrado com sucesso", Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        veiculoRepository.getAll(new VeiculoRepository.Callback<List<Veiculos>>() {
            @Override
            public void onResult(List<Veiculos> model) {
                rv.setAdapter(new VeiculoAdapter(getApplicationContext(), model));
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onEmpty() {

                Toast.makeText(AdicionarVeiculosView.this, "Não a dados", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


}
