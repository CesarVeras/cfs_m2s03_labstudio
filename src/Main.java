import enumerators.Nivel;
import modelos.Cargo;
import modelos.Colaborador;

import java.util.*;

public class Main {
    public static ArrayList<Colaborador> colaboradores = new ArrayList<>();
    public static Scanner  s = new Scanner(System.in);

    public static void main(String[] args) {
        Colaborador colab;

        // Ex 4 - Fazer inclusão de novo colaborador em lista de Colaboradores
        colab = new Colaborador("Eduardo", new Date(), new Cargo("Programador Web", 3000, Nivel.PLENO), 3000);
        colaboradores.add(colab);

        colab = new Colaborador("Carla", new Date(), new Cargo("Programador Web", 1000, Nivel.JUNIOR), 1500);
        colab.setDataDesligamento(new Date());
        colaboradores.add(colab);

        // Ex 5 - Listar colaboradores ativos ( que não possuem data desligamento )
        StringBuilder saida = new StringBuilder();
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getDataDesligamento() == null) {
                saida.append(colaborador);
            }
        }
        System.out.println(saida);
//        adicionarColaborador();
//        listarPorCargo(new Cargo("aaaa", 1000, Nivel.PLENO));
//        colaboradores.forEach(System.out::print);
//        System.out.println("\n");
//        removerColaborador(colab);
//        colaboradores.forEach(System.out::print);
//        colaboradores.forEach(System.out::print);
//        System.out.println("\n");
//        promoverPorCargo(colab.getCargo());
//        colaboradores.forEach(System.out::print);
        listarSalarioDesc();
    }

    // Ex 6 - Listar colaboradores por Cargo
    public static void listarPorCargo(Cargo cargo) {
        StringBuilder saida = new StringBuilder();
        for (Colaborador c : colaboradores) {
            if (c.getCargo().getDescricao().toLowerCase().equals(cargo.getDescricao().toLowerCase())
                && c.getCargo().getSalarioBase() == cargo.getSalarioBase()
                    && c.getCargo().getNivel() == c.getCargo().getNivel()
            ) {
                saida.append(c);
            }
        }
        if (saida.isEmpty()) {
            saida.append("Sem resultados para o cargo: " + cargo);
        }
        System.out.println(saida);
    }

    // Ex 7 - Desenvolver um método que será responsável por admitir um colaborador (incluir na lista de colaboradores)
    public static void adicionarColaborador() {
        String nome, data, dados[], descricao, nivelS;
        int dia, mes, ano;
        float salario, salarioBase;
        Nivel nivel;

        System.out.print("Cadastrar colaborador.\nInforme o nome do colaborador: ");
        nome = s.nextLine();

        System.out.print("Informe a data de admissão (dd/mm/aaaa): ");
        data = s.next();
        dados = data.split("/");
        dia = Integer.parseInt(dados[0]);
        mes = Integer.parseInt(dados[1]) - 1;
        ano = Integer.parseInt(dados[2]);
        Date dataAdmissao = new GregorianCalendar(ano, mes, dia).getTime();

        System.out.print("Informe o salário: ");
        salario = s.nextFloat();

        System.out.print("Informações sobre o cargo do colaborador.\nInforme a descrição do cargo do colaborador: ");
        descricao = s.next();

        System.out.println("Informe o salário base: ");
        salarioBase = s.nextFloat();

        System.out.println("Informe o nível (junior/pleno/senior): ");
        nivelS = s.next().toLowerCase();

        if (nivelS.equals("junior")) {
            nivel = Nivel.JUNIOR;
        } else if (nivelS.equals("pleno")) {
            nivel = Nivel.PLENO;
        } else {
            nivel = Nivel.SENIOR;
        }

        Colaborador colaborador = new Colaborador(nome, dataAdmissao, new Cargo(descricao, salarioBase, nivel), salario);
        System.out.println(colaborador);
        colaboradores.add(colaborador);
    }

    // Ex 8 - Desenvolver um método que será responsável por desligar um colaborador ( alterar o objeto incluindo uma data de desligamento )
    public static void removerColaborador(Colaborador colaborador) {
        colaboradores.remove(colaborador);
    }

    // Ex 9 - Desenvolver um método que será responsável por promover um colaborador de Cargo
    public static void promoverPorCargo(Cargo cargo) {
        for (Colaborador c : colaboradores) {
            if (c.getCargo() == cargo) {
                if (c.getCargo().getNivel() == Nivel.JUNIOR) {
                    c.getCargo().setNivel(Nivel.PLENO);
                } else if (c.getCargo().getNivel() == Nivel.PLENO) {
                    c.getCargo().setNivel(Nivel.SENIOR);
                }
            }
        }
    }

    // Ex 10 - Listar colaboradores ordenado por salário decrescente
    public static void listarSalarioDesc() {
        ArrayList<Colaborador> clone = (ArrayList<Colaborador>) colaboradores.clone();
        Collections.sort(clone, new Comparator<Colaborador>() {
            @Override
            public int compare(Colaborador o1, Colaborador o2) {
                return Float.compare(o2.getSalario(), o1.getSalario());
            }
        });
        clone.forEach(System.out::print);
    }
}
