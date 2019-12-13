package br.senac.go.projetoandroid.data.repository;

public interface RepositorioCallback<T> {

    void onResult(T model);
    void onEmpty();
}
