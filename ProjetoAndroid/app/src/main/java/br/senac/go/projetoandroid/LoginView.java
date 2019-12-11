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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);


        et_nome = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);
        bt_login = (Button) findViewById(R.id.bt_login);
        userApiSource = Usuario.getUserApiSource();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_nome.getText().toString();
                String senha = et_senha.getText().toString();
                if (validateLogin(name, senha)) {

                    doLogin(name, senha);
                }

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

    private void doLogin(final String name, String senha) {
        Call call = userApiSource.createUsuario(name,senha);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    Usuario usuario = (Usuario) response.body();
                    if (usuario.getId().equals("true")) {
                        //login start
                        Intent intent = new Intent(LoginView.this, LoginView.class);
                        intent.putExtra("username", name);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginView.this, "o nome esta incorreto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginView.this, "erro na senha", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginView.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });
    }
}