package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Usuario;
import br.senac.go.projetoandroid.data.model.Veiculos;

public interface IUserRepository {
    void getAll(IUserRepository.Callback<List<Usuario>> callback);

    void createUsuario(IUserRepository.Callback<Usuario> callback, Usuario usuario);


    interface Callback<ResultType> {
        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
