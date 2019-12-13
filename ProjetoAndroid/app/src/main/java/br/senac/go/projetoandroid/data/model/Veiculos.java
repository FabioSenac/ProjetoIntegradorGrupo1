package br.senac.go.projetoandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;
@Entity
public class Veiculos {
    @PrimaryKey
    private Long vei_id;
    private String placa;
    private String tipo;

    public Veiculos(Long vei_id, String placa, String tipo) {
        this.vei_id = vei_id;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Long getVei_id() {
        return vei_id;
    }

    public void setVei_id(Long vei_id) {
        this.vei_id = vei_id;
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
        return Objects.equals(getVei_id(), veiculos.getVei_id()) &&
                Objects.equals(getPlaca(), veiculos.getPlaca()) &&
                Objects.equals(getTipo(), veiculos.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVei_id(), getPlaca(), getTipo());
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "vei_id=" + vei_id +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
