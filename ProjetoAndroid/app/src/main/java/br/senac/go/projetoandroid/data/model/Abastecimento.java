package br.senac.go.projetoandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity
public class Abastecimento {
    @PrimaryKey
    private Long id;
    private Date data;
    private double totlitros;
    private int odometro;
    private double valor_unit;

    public Abastecimento(Long id, Date data, double totlitros, int odometro, double valor_unit) {
        this.id = id;
        this.data = data;
        this.totlitros = totlitros;
        this.odometro = odometro;
        this.valor_unit = valor_unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotlitros() {
        return totlitros;
    }

    public void setTotlitros(double totlitros) {
        this.totlitros = totlitros;
    }

    public int getOdometro() {
        return odometro;
    }

    public void setOdometro(int odometro) {
        this.odometro = odometro;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(double valor_unit) {
        this.valor_unit = valor_unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abastecimento)) return false;
        Abastecimento that = (Abastecimento) o;
        return Double.compare(that.getTotlitros(), getTotlitros()) == 0 &&
                getOdometro() == that.getOdometro() &&
                Double.compare(that.getValor_unit(), getValor_unit()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getTotlitros(), getOdometro(), getValor_unit());
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", data=" + data +
                ", totlitros=" + totlitros +
                ", odometro=" + odometro +
                ", valor_unit=" + valor_unit +
                '}';
    }
}
