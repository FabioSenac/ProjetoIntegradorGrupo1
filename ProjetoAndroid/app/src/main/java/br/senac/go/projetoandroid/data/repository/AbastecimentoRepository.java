package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Abastecimento;
import br.senac.go.projetoandroid.data.repository.source.AbastecimentoApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbastecimentoRepository implements  IAbastecimentoRepository {


private AbastecimentoApiSource abastecimentoApiSource;
public AbastecimentoRepository (AbastecimentoApiSource abastecimentoApiSource){
    this.abastecimentoApiSource = abastecimentoApiSource;
}


    @Override
    public void getAll(final Callback<List<Abastecimento>> callback) {
        abastecimentoApiSource.getAll().enqueue(new retrofit2.Callback<List<Abastecimento>>() {
            @Override
            public void onResponse(Call<List<Abastecimento>> call, Response<List<Abastecimento>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Abastecimento>> call, Throwable t) {
                callback.onEmpty();

            }
        });
    }

    @Override
    public void createAbastecimento(final Callback<Abastecimento> callback, Abastecimento abastecimento) {
abastecimentoApiSource.createAbastecimento(abastecimento).enqueue(new retrofit2.Callback<Abastecimento>() {
    @Override
    public void onResponse(Call<Abastecimento> call, Response<Abastecimento> response) {
        callback.onResult(response.body());
    }

    @Override
    public void onFailure(Call<Abastecimento> call, Throwable t) {

    }
});
    }
}
