package br.senac.go.projetoandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;
@Entity
public class Veiculos {
    @PrimaryKey
    private Long id;
    private String placa;
    private String tipo;

    public Veiculos(Long id, String placa, String tipo) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculos)) return false;
        Veiculos veiculos = (Veiculos) o;
        return Objects.equals(getId(), veiculos.getId()) &&
                Objects.equals(getPlaca(), veiculos.getPlaca()) &&
                Objects.equals(getTipo(), veiculos.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlaca(), getTipo());
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
