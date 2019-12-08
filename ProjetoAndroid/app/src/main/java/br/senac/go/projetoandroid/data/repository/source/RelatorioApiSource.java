package br.senac.go.projetoandroid.data.repository.source;

import java.util.List;


import br.senac.go.projetoandroid.data.model.Relatorio;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RelatorioApiSource {

    @GET("/SaidaAbast")
    Call<List<Relatorio>> getAll();
}
