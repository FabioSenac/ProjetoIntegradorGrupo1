package br.senac.go.projetoandroid.data.repository.source;

import java.util.List;


import br.senac.go.projetoandroid.data.model.Veiculos;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VeiculoApiSource {

    @GET("/veiculo")
    Call<List<Veiculos>> getAll();

    @POST("/veiculo")
    Call<Veiculos> createVeiculo(@Body Veiculos veiculos);
}
