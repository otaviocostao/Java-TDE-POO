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
            exibirMenu(); // Exibir os prints do Menu
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
                    buscarFuncionario(); // Buscar funcionario pelo código
                    break;
                case 8:
                    buscarEquipamento(); // Buscar equipamento pelo código
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("Deseja sair do sistema? [0]Não [1]Sim: ");
            sair = scanner.nextInt(); // Opção para sair do while

        } while (sair == 0); // ecerramento do laço

        scanner.close(); // fechando o scanner
    }

    // Função para exibir o menu
    public void exibirMenu() {
        System.out.println("--- MENU ---");
        System.out.println("[1] - Cadastrar novo funcionário");
        System.out.println("[2] - Cadastrar novo equipamento");
        System.out.println("[3] - Cadastrar novo empréstimo");
        System.out.println("[4] - Listar funcionários cadastrados");
        System.out.println("[5] - Listar equipamentos cadastrados");
        System.out.println("[6] - Listar empréstimos de equipamentos");
        System.out.println("[7] - Buscar funcionário pelo código");
        System.out.println("[8] - Buscar equipamento pelo código");
        System.out.println("Digite a opção desejada: ");
    }

    // Buscar funcionário pelo código
    public void buscarFuncionario() {
        System.out.println("Digite o código do funcionário que deseja buscar: ");
        String codBuscaFunc = scanner.nextLine(); // Variável que será buscada

        Funcionario funcionarioEncontrado = gerenciadorFuncionarios.buscarFuncionario(codBuscaFunc); // Instanciando um funcionario temporário

        if (funcionarioEncontrado != null) { // Caso encontre o funcionário
            funcionarioEncontrado.infoFuncionario(); // metodo de funcionario para exibir as informações
        } else { // caso não encontre o funcionario
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Buscar equipamento pelo código
    public void buscarEquipamento() {
        System.out.println("Digite o código do equipamento que deseja buscar: ");
        String codBuscaEqp = scanner.nextLine(); // Variável que será buscada

        Equipamento equipamentoEncontrado = gerenciadorEquipamentos.buscarEquipamento(codBuscaEqp);  // Instanciando um equipamento temporário

        if (equipamentoEncontrado != null) {
            equipamentoEncontrado.infoEquipamento(); // Metodo de equipamento para exibir as informações
        } else {// caso não encontre o equipamento
            System.out.println("Equipamento não encontrado.");
        }
    }
}
