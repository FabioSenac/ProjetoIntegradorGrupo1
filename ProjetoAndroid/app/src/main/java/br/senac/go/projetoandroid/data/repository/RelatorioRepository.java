package br.senac.go.projetoandroid.data.repository;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Abastecimento;
import br.senac.go.projetoandroid.data.model.Relatorio;
import br.senac.go.projetoandroid.data.repository.source.RelatorioApiSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatorioRepository implements RelatorioApiSource {

private RelatorioApiSource relatorioApiSource;

    public RelatorioRepository(RelatorioApiSource relatorioApiSource) {
        this.relatorioApiSource = relatorioApiSource;
    }

    @Override
    public Call<List<Relatorio>> getAll() {
        relatorioApiSource.getAll().enqueue(new Callback<List<Relatorio>>() {
            @Override
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                IRelatorioRepository.Callback<List<Relatorio>> callback = null;
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                IRelatorioRepository.Callback callback = null;
                callback.onEmpty();
            }
        });
        return null;
    }
}
