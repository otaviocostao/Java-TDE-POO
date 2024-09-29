import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in); // Instanciando um Scanner para fazer leitura do input
    public static GerenciadorFuncionarios gerenciadorFuncionarios = new GerenciadorFuncionarios(); // Instaciando a classe Gerenciador Funcionarios para usar suas funções
    public static GerenciadorEquipamentos gerenciadorEquipamentos = new GerenciadorEquipamentos(); // Instaciando a classe Gerenciador Equipamentos para usar suas funções
    public static GerenciadorEmprestimos gerenciadorEmprestimos = new GerenciadorEmprestimos(); // Instaciando a classe Gerenciador Emprestimos para usar suas funções

    public static void main(String[] args) {
        iniciar(); // Iniciando a função com o Switch Case, menu e outras funções
    }

    public static void iniciar() {
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
                    if (!gerenciadorFuncionarios.verListaVazia() && !gerenciadorEquipamentos.verListaVazia()){
                        gerenciadorEmprestimos.novoEmprestimo(scanner, gerenciadorFuncionarios,  gerenciadorEquipamentos); // Função de cadastrar Emprestimos
                    }else{
                        System.out.println("Não é possivel realizar emprestimos, cadastre ao menos um funcionario e um equipamento");
                    }
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
                    gerenciadorFuncionarios.excluirFuncionario();
                    break;
                case 10:
                    gerenciadorEquipamentos.excluirEquipamento();
                    break;
                case 11:
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
