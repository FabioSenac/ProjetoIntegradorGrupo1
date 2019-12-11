package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Abastecimento;
import br.senac.go.projetoandroid.data.model.Relatorio;
import br.senac.go.projetoandroid.data.repository.source.RelatorioApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatorioRepository implements IRelatorioRepository {

    private RelatorioApiSource relatorioApiSource;

    public RelatorioRepository(RelatorioApiSource relatorioApiSource) {
        this.relatorioApiSource = relatorioApiSource;
    }


    @Override
    public void getAll(final Callback<List<Relatorio>> callback) {
        relatorioApiSource.getAll().enqueue(new retrofit2.Callback<List<Relatorio>>() {
            @Override
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }
}
