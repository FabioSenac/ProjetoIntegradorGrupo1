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
    public void getAll(final Callback<List<Usuario>> callback) {
        userApiSource.getAll().enqueue(new retrofit2.Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                callback.onEmpty();
            }
        });


    }

    @Override
    public void createUsuario(final Callback<Usuario> callback, Usuario usuario) {
userApiSource.getAll().enqueue(new retrofit2.Callback<List<Usuario>>() {
    @Override
    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
        callback.onResult((Usuario) response.body());
    }

    @Override
    public void onFailure(Call<List<Usuario>> call, Throwable t) {

    }
});
    }
}
