package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Usuario;
import br.senac.go.projetoandroid.data.repository.source.RelatorioApiSource;
import br.senac.go.projetoandroid.data.repository.source.UserApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository implements IUserRepository {

    private UserApiSource userApiSource;

    public UserRepository(UserApiSource userApiSource) {
        this.userApiSource = userApiSource;
    }


    @Override
    public void getAll(Callback<List<Usuario>> callback) {

    }

    @Override
    public void createUsuario(Callback<Usuario> callback, Usuario usuario) {

    }

    @Override
    public void createUsuario(Call<Usuario> usuarioCall) {

    }
}
