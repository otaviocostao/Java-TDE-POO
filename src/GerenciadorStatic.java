import java.util.Scanner;

// Classe com os metodos estaticos, para organizar melhor o código
public class GerenciadorStatic {

    // Função para exibir o menu
    public static void exibirMenu() {
        System.out.println("--- MENU ---");
        System.out.println("[1] - Cadastrar novo funcionário");
        System.out.println("[2] - Cadastrar novo equipamento");
        System.out.println("[3] - Cadastrar novo empréstimo");
        System.out.println("[4] - Listar funcionários cadastrados");
        System.out.println("[5] - Listar equipamentos cadastrados");
        System.out.println("[6] - Listar empréstimos de equipamentos");
        System.out.println("[7] - Buscar funcionário pelo código");
        System.out.println("[8] - Buscar equipamento pelo código");
        System.out.println("[9] - Sair");
        System.out.println("Digite a opção desejada: ");
    }

    // Buscar funcionário pelo código
    public static void buscarFuncionario(Scanner scanner, GerenciadorFuncionarios gerenciadorFuncionarios) {
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
    public static void buscarEquipamento(Scanner scanner, GerenciadorEquipamentos gerenciadorEquipamentos) {
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
