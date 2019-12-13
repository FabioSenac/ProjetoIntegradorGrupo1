package br.senac.go.projetoandroid.data.repository.source;

import java.util.List;


import br.senac.go.projetoandroid.data.model.Relatorio;
import br.senac.go.projetoandroid.data.model.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RelatorioApiSource {

    @GET("/relatorio")
    Call<List<Relatorio>> getAll();
}
