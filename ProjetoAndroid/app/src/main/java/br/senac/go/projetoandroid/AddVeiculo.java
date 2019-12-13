package br.senac.go.projetoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.senac.go.projetoandroid.data.model.Veiculos;
import br.senac.go.projetoandroid.data.repository.IVeiculoRepository;
import br.senac.go.projetoandroid.data.repository.RepositorioCallback;
import br.senac.go.projetoandroid.data.repository.VeiculoRepository;
import br.senac.go.projetoandroid.data.repository.source.VeiculoApiSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddVeiculo extends AppCompatActivity {
    private IVeiculoRepository veiculoRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_veiculo);


//==================================================================================================

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081/")
                //.baseUrl("http://172.16.1.94:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VeiculoApiSource api = retrofit.create(VeiculoApiSource.class);

        veiculoRepository = new VeiculoRepository(api);


//==================================================================================================


//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

//       // final  String varCarroEnv;
//        final RadioButton varCarro = findViewById(R.id.rd_bt_auto);
//        varCarro.setOnClickListener(new View.OnClickListener() {
//            Carro carro = new Carro();
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(AddVeiculo.this, "PASSOU CARRO", Toast.LENGTH_SHORT).show();
//             //   varCarroEnv = "Carro";
//
//                carro.setVei_tipo("Carro");
//            }
//        });
//
//
//        //-----------------------------------------
//
//
//       // final String varMotoEnv ;
//        final RadioButton varMoto = findViewById(R.id.rd_bt_moto);
//        varMoto.setOnClickListener(new View.OnClickListener() {
//            Carro carro = new Carro();
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(AddVeiculo.this, "PASSOU MOTO", Toast.LENGTH_SHORT).show();
//           //     varMotoEnv = "Moto";
//
//
//
//            carro.setVei_tipo("Moto");
//
//            }
//        });


//==================================================================================================

        Button Bt_Salvar = findViewById(R.id.bt_salvar);
        final EditText edit_Placa = findViewById(R.id.et_placa);

        edit_Placa.setText("");

        Bt_Salvar.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View v) {

                                             String varCarro = "0", varMoto = "0";
                                             Veiculos veiculos = new Veiculos();

                                             RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
                                             switch (radioGroup.getCheckedRadioButtonId()) {
                                                 case R.id.rd_bt_auto:
                                                     varCarro = "Carro";
                                                     break;
                                                 case R.id.rd_bt_moto:
                                                     varMoto = "Moto";
                                                     break;

                                             }
                                             if (varCarro.equals("Carro")) {
                                                 Toast.makeText(getApplicationContext(), "Carro selecionado", Toast.LENGTH_SHORT).show();
                                                 veiculos.setTipo(varCarro);
                                             } else {
                                                 Toast.makeText(getApplicationContext(), "Moto selecionada", Toast.LENGTH_SHORT).show();
                                                 veiculos.setTipo(varMoto);
                                             }

                                             veiculos.setTipo(edit_Placa.getText().toString());
                                             String PlacaString = edit_Placa.getText().toString();


                                             Toast.makeText(AddVeiculo.this, "a placa é:" + PlacaString, Toast.LENGTH_SHORT).show();
                                             // Carro carro = new Carro();


//                                             if (varCarro.equals(findViewById(R.id.rd_bt_auto))) {
//                                                 carro.setVei_placa(PlacaString);
//                                                 carro.setVei_tipo("Carro");
//                                             }
//
//                                             if (varMoto.equals(findViewById(R.id.rd_bt_moto))) {
//                                                 carro.setVei_placa(PlacaString);
//                                                 carro.setVei_tipo("Moto");
//                                             }
                                             //
                                             veiculoRepository.postVeiculo(veiculos, new RepositorioCallback<Veiculos>() {
                                                 @Override
                                                 public void onResult(Veiculos model) {
                                                     Toast.makeText(AddVeiculo.this, "Veículo cadastrado", Toast.LENGTH_SHORT).show();
                                                 }

                                                 @Override
                                                 public void onEmpty() {

                                                 }


                                             });

                                         }


                                     }

//==================================================================================================

        );


//==================================================================================================

        // Carro carro = new Carro();


//        if (varCarro.equals()) {
//         //   Toast.makeText(AddVeiculo.this, "CARRO VAZIO", Toast.LENGTH_SHORT).show();
//            carro.setVei_tipo("Carro");
//        }
//
//
//        if (!varMoto.equals("")) {
//            //Toast.makeText(AddVeiculo.this, "CARRO VAZIO", Toast.LENGTH_SHORT).show();
//            carro.setVei_tipo("Moto");
//        }


        //----------------------


        //      carro.setVei_placa("placa");
//                carroRepository.postCarro(carro, new RepositorioCallback<Carro>() {
//                    @Override
//                    public void onResult(Carro model) {
//                        Toast.makeText(AddVeiculo.this, "Foi enviado", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onEmpty() {
//
//                    }
//                });


//==================================================================================================

    }
}

