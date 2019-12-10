package br.senac.go.projetoandroid.data.repository.source;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiSource {
    @GET("/usuario")
    Call<List<Usuario>> getAll();

    @POST("/usuario")
    Call<Usuario> createUsuario(@Body Usuario usuario);

    Call createUsuario(String name, String senha);
}
