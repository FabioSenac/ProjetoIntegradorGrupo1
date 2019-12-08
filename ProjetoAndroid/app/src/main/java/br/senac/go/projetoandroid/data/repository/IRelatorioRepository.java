package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Abastecimento;
import br.senac.go.projetoandroid.data.model.Relatorio;

public interface IRelatorioRepository {

    void getAll(IRelatorioRepository.Callback<List<Relatorio>> callback);
    interface Callback<ResultType> {
        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
