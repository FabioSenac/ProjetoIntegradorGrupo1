package br.senac.go.projetoandroid.data.dao;

import br.senac.go.projetoandroid.data.repository.source.UserApiSource;

public class conectaWebService {
    public static final String BASE_URL = "http://localhost/abastecimento/";

    public static UserApiSource userApiSource(){
        return RetrofitCliente.getUsuario(BASE_URL).create(UserApiSource.class);
    }
}
