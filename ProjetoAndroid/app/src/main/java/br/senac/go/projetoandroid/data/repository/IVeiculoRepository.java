package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Veiculos;

public interface IVeiculoRepository {
    void getAll(IVeiculoRepository.Callback<List<Veiculos>> callback);

    void postVeiculo(Veiculos veiculos, RepositorioCallback<Veiculos> callback);

    interface Callback<ResultType> {
        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
