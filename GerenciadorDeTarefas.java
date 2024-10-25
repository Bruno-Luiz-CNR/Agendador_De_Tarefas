package src.academy.devdojo.javacore.introducaoclasses.teste;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class GerenciadorDeTarefas {
    private ArrayList<String> tarefas;

    public GerenciadorDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        LocalDate dataAgora = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada: " + tarefa + ", Adicionado ás : " + dataAgora + " " + horaAtual);
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            String tarefaRemovida = tarefas.remove(indice);
            System.out.println("Tarefa removida: " + tarefaRemovida);
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada");
        } else {
            System.out.println("Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println(i + ": " + tarefas.get(i));
            }
        }
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Comandos: adicionar, remover, listar, sair");
            comando = scanner.nextLine();

            switch (comando) {
                case "adicionar":
                    System.out.println("-".repeat(40));
                    gerenciador.listarTarefas();
                    System.out.println("-".repeat(40));
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    gerenciador.adicionarTarefa(tarefa);
                    System.out.println("-".repeat(40));
                    break;
                case "remover":
                    System.out.println("*".repeat(40));
                    gerenciador.listarTarefas();
                    System.out.println("*".repeat(40));
                    System.out.print("Digite o índice da tarefa para remover: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    gerenciador.removerTarefa(indice);
                    gerenciador.listarTarefas();
                    System.out.println("*".repeat(40));
                    break;
                case "listar":
                    System.out.println("+".repeat(40));
                    gerenciador.listarTarefas();
                    System.out.println("+".repeat(40));
                    break;
                case "sair":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Comando inválido!");
            }
        } while (!comando.equals("sair"));

        scanner.close();
    }
}
