package modelos;

import java.util.Date;

// Ex 3 - Classe Colaborador ( Nome, data admissão, data desligamento, Cargo, Salário )
public class Colaborador {
    private String nome;
    private Date dataAdmissao;
    private Date dataDesligamento;
    private Cargo cargo;
    private float salario;

    public Colaborador() {}

    public Colaborador(String nome, Date dataAdmissao, Cargo cargo, float salario) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "nome='" + nome + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", dataDesligamento=" + dataDesligamento +
                ", cargo=" + cargo +
                ", salario=" + salario +
                '}';
    }
}
