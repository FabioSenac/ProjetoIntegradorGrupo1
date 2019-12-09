package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Veiculos;

public interface IVeiculoRepository {
    void getAll(IVeiculoRepository.Callback<List<Veiculos>> callback);
    void createVeiculo(IVeiculoRepository.Callback<Veiculos> callback, Veiculos veiculos);

    interface Callback<ResultType> {
        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
