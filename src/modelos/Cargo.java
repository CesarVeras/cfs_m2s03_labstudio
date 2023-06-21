package modelos;

import enumerators.Nivel;

import java.util.Objects;

// Ex 2 - Classe Cargo ( Descrição, Salário base , Nível (classe Enum) )
public class Cargo {
    private String descricao;
    private float salarioBase;
    private Nivel nivel;

    public Cargo() {}
    public Cargo(String descricao, float salarioBase, Nivel nivel) {
        this.descricao = descricao;
        this.salarioBase = salarioBase;
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Float.compare(cargo.salarioBase, salarioBase) == 0 && Objects.equals(descricao, cargo.descricao) && nivel == cargo.nivel;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "descricao='" + descricao + '\'' +
                ", salarioBase=" + salarioBase +
                ", nivel=" + nivel +
                '}';
    }
}
