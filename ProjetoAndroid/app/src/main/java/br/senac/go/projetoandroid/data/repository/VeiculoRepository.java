package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Veiculos;
import br.senac.go.projetoandroid.data.repository.source.VeiculoApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VeiculoRepository implements IVeiculoRepository {

    private VeiculoApiSource veiculoApiSource;

    public VeiculoRepository(VeiculoApiSource veiculoApiSource) {
        this.veiculoApiSource = veiculoApiSource;


    }

    @Override
    public void getAll(final Callback<List<Veiculos>> callback) {
        veiculoApiSource.getAll().enqueue(new retrofit2.Callback<List<Veiculos>>() {
            @Override
            public void onResponse(Call<List<Veiculos>> call, Response<List<Veiculos>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Veiculos>> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }

    @Override
    public void postVeiculo(Veiculos veiculos, final RepositorioCallback<Veiculos> callback) {
        veiculoApiSource.postVeiculo(veiculos).enqueue(new retrofit2.Callback<Veiculos>() {
            @Override
            public void onResponse(Call<Veiculos> call, Response<Veiculos> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Veiculos> call, Throwable t) {

            }
        });
    }


}
