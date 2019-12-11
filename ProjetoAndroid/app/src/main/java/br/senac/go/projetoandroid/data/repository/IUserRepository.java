package br.senac.go.projetoandroid.data.repository;

import android.widget.Toast;

import java.util.List;

import br.senac.go.projetoandroid.LoginView;
import br.senac.go.projetoandroid.data.model.Usuario;
import br.senac.go.projetoandroid.data.model.Veiculos;

public interface IUserRepository {
    void getAll(IUserRepository.Callback<List<Usuario>> callback);

    void createUsuario(IUserRepository.Callback<Usuario> callback, Usuario usuario);

    void createUsuario(Call<Usuario> usuarioCall);


    interface Callback<ResultType> {
        void onResult(ResultType result);


        void onError(Exception e);

        void onEmpty();
    }

    public class Call<T> {
    }
}
