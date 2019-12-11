package br.senac.go.projetoandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Relatorio {
    @PrimaryKey
    private Long id;
    private String veiculos;
    private String Placa;
    private String Post_caro;
    private double Vl_unit_caro;
    private String Post_barato;
    private double Vl_unit_barato;
    private double media_Km;

    public Relatorio(Long id, String veiculos, String placa, String post_caro, double vl_unit_caro, String post_barato, double vl_unit_barato, double media_Km) {
        this.id = id;
        this.veiculos = veiculos;
        Placa = placa;
        Post_caro = post_caro;
        Vl_unit_caro = vl_unit_caro;
        Post_barato = post_barato;
        Vl_unit_barato = vl_unit_barato;
        this.media_Km = media_Km;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(String veiculos) {
        this.veiculos = veiculos;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getPost_caro() {
        return Post_caro;
    }

    public void setPost_caro(String post_caro) {
        Post_caro = post_caro;
    }

    public double getVl_unit_caro() {
        return Vl_unit_caro;
    }

    public void setVl_unit_caro(double vl_unit_caro) {
        Vl_unit_caro = vl_unit_caro;
    }

    public String getPost_barato() {
        return Post_barato;
    }

    public void setPost_barato(String post_barato) {
        Post_barato = post_barato;
    }

    public double getVl_unit_barato() {
        return Vl_unit_barato;
    }

    public void setVl_unit_barato(double vl_unit_barato) {
        Vl_unit_barato = vl_unit_barato;
    }

    public double getMedia_Km() {
        return media_Km;
    }

    public void setMedia_Km(double media_Km) {
        this.media_Km = media_Km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relatorio)) return false;
        Relatorio relatorio = (Relatorio) o;
        return Double.compare(relatorio.getVl_unit_caro(), getVl_unit_caro()) == 0 &&
                Double.compare(relatorio.getVl_unit_barato(), getVl_unit_barato()) == 0 &&
                Double.compare(relatorio.getMedia_Km(), getMedia_Km()) == 0 &&
                Objects.equals(getId(), relatorio.getId()) &&
                Objects.equals(getVeiculos(), relatorio.getVeiculos()) &&
                Objects.equals(getPlaca(), relatorio.getPlaca()) &&
                Objects.equals(getPost_caro(), relatorio.getPost_caro()) &&
                Objects.equals(getPost_barato(), relatorio.getPost_barato());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVeiculos(), getPlaca(), getPost_caro(), getVl_unit_caro(), getPost_barato(), getVl_unit_barato(), getMedia_Km());
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "id=" + id +
                ", veiculos='" + veiculos + '\'' +
                ", Placa='" + Placa + '\'' +
                ", Post_caro='" + Post_caro + '\'' +
                ", Vl_unit_caro=" + Vl_unit_caro +
                ", Post_barato='" + Post_barato + '\'' +
                ", Vl_unit_barato=" + Vl_unit_barato +
                ", media_Km=" + media_Km +
                '}';
    }
}
