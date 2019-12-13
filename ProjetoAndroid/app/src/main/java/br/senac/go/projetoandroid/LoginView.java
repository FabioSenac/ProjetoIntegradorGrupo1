package br.senac.go.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.go.projetoandroid.data.model.Usuario;
import br.senac.go.projetoandroid.data.repository.IUserRepository;
import br.senac.go.projetoandroid.data.repository.UserRepository;
import br.senac.go.projetoandroid.data.repository.source.UserApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginView extends AppCompatActivity {

    EditText et_nome;
    EditText et_senha;
    Button bt_login;
    UserApiSource userApiSource;
    private IUserRepository UserRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);


        et_nome = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);
        bt_login = (Button) findViewById(R.id.bt_login);
        //userApiSource = LoginView.RESULT_FIRST_USER;


        String usu_id;
        Object usu_nome;
        final Usuario user= new Usuario();
        user.setUsu_nome("name");
        user.getUsu_senha();


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = et_nome.getText().toString();
                String senha = et_senha.getText().toString();
                if (validateLogin(name, senha)) {

                    //doLogin(name, senha);
                }

                UserRepository.createUsuario(new IUserRepository.Callback<Usuario>() {

                    @Override
                    public void onResult(Usuario result) {
                        Intent intent = new Intent(getApplicationContext(),ListaVeiculosView.class);
                        //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("name",name);
                        startActivity(intent);

                        Toast.makeText(LoginView.this, "Salvo com Sucesso" + result.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(LoginView.this, "erro na senha", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {
                        Toast.makeText(LoginView.this, "o nome esta incorreto", Toast.LENGTH_SHORT).show();
                    }
                }, user);

            }
        });


    }

    private boolean validateLogin(String name, String senha) {
        if (name == null || name.trim().length() == 0) {
            Toast.makeText(this, "falta o nome", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (senha == null || senha.trim().length() == 0) {
            Toast.makeText(this, "falta a senha", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}