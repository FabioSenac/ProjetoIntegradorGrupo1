package br.senac.go.projetoandroid.data.repository.source;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Abastecimento;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AbastecimentoApiSource {

    @GET("/abastecimento")
    Call<List<Abastecimento>> getAll();

    @POST("/abastecimento")
    Call<Abastecimento> createAbastecimento(@Body Abastecimento abastecimento);
}
