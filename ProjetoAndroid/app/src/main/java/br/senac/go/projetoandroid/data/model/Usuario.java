package br.senac.go.projetoandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

import br.senac.go.projetoandroid.data.repository.source.UserApiSource;

@Entity
public class Usuario {

    @PrimaryKey
    private  Long usu_id;
    private String usu_nome;
    private String usu_senha;

    public Usuario(Long usu_id, String usu_nome, String usu_senha) {
        this.usu_id = usu_id;
        this.usu_nome = usu_nome;
        this.usu_senha = usu_senha;
    }

    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getUsu_id(), usuario.getUsu_id()) &&
                Objects.equals(getUsu_nome(), usuario.getUsu_nome()) &&
                Objects.equals(getUsu_senha(), usuario.getUsu_senha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsu_id(), getUsu_nome(), getUsu_senha());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usu_id=" + usu_id +
                ", usu_nome='" + usu_nome + '\'' +
                ", usu_senha='" + usu_senha + '\'' +
                '}';
    }
}
