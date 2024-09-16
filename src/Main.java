import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in); // Instanciando um Scanner para fazer leitura do input
    private GerenciadorFuncionarios gerenciadorFuncionarios = new GerenciadorFuncionarios(); // Instaciando a classe Gerenciador Funcionarios para usar suas funções
    private GerenciadorEquipamentos gerenciadorEquipamentos = new GerenciadorEquipamentos(); // Instaciando a classe Gerenciador Equipamentos para usar suas funções
    private GerenciadorEmprestimos gerenciadorEmprestimos = new GerenciadorEmprestimos(); // Instaciando a classe Gerenciador Emprestimos para usar suas funções

    public static void main(String[] args) {
        Main main = new Main(); // Instanciando Main
        main.iniciar(); // Iniciando a função com o Switch Case, menu e outras funções
    }

    public void iniciar() {
        int sair = 0;
        int opcao;

        do {
            GerenciadorStatic.exibirMenu(); // Exibir os prints do Menu
            opcao = scanner.nextInt(); // Ler a opção no menu
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) { // Switch case para acessar os métodos
                case 1:
                    gerenciadorFuncionarios.cadastrarFuncionario(scanner); // Função de cadastrar funcionario
                    break;
                case 2:
                    gerenciadorEquipamentos.cadastrarEquipamento(scanner); // Função de cadastrar equipamento
                    break;
                case 3:
                    gerenciadorEmprestimos.novoEmprestimo(scanner); // Função de cadastrar Emprestimos
                    break;
                case 4:
                    gerenciadorFuncionarios.listarFuncionariosCad(); // Função para listar funcionarios
                    break;
                case 5:
                    gerenciadorEquipamentos.listarEquipamentosCad(); // Função para listar equipamentos
                    break;
                case 6:
                    gerenciadorEmprestimos.listarEmprestimosCad(); //Função para listar emprestimos
                    break;
                case 7:
                    GerenciadorStatic.buscarFuncionario(scanner, gerenciadorFuncionarios); // Buscar funcionario pelo código
                    break;
                case 8:
                    GerenciadorStatic.buscarEquipamento(scanner, gerenciadorEquipamentos); // Buscar equipamento pelo código
                    break;
                case 9:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("Deseja sair do sistema? [0]Não [1]Sim: ");
            sair = scanner.nextInt(); // Opção para sair do while

        } while (sair == 0); // encerramento do laço

        scanner.close(); // fechando o scanner
    }

}
