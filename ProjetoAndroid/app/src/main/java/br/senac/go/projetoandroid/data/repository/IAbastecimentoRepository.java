package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import javax.security.auth.callback.Callback;

import br.senac.go.projetoandroid.data.model.Abastecimento;

public interface IAbastecimentoRepository {

void getAll(Callback<List<Abastecimento>> callback);
void createAbastecimento(Callback<Abastecimento>callback, Abastecimento  abastecimento);

    interface Callback<ResultType> {
        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
