import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        int sair = 0;
        int opcao;
        do {
            GerenciadorTrackBug.menu();
            opcao = main.scanner.nextInt();
            switch (opcao){
                case 1:
                    main.scanner.nextLine();

                    System.out.println("--- Cadastrar novo funcionario ---");
                    System.out.println("Digite o código do funcionario: ");
                    String codFuncionarioTemp = main.scanner.nextLine();
                    System.out.println("Digite o nome do funcionário: ");
                    String nomeFuncionarioTemp = main.scanner.nextLine();
                    System.out.println("Digite a função do funcionáro: ");
                    String funcaoFuncionarioTemp = main.scanner.nextLine();
                    System.out.println("Digite a data de admissão: ");
                    String dataAdmissaoTemp = main.scanner.nextLine();

                    Funcionario funcionario = new Funcionario(codFuncionarioTemp, nomeFuncionarioTemp, funcaoFuncionarioTemp, dataAdmissaoTemp);
                    GerenciadorTrackBug.cadastrarFuncionario(funcionario);

                    break;
                case 2:
                    main.scanner.nextLine();
                    System.out.println("--- Cadastrar equipamento ---");
                    System.out.println("Digite o código do equipamento: ");
                    String codEqpTemp = main.scanner.nextLine();
                    System.out.println("Digite a descrição do equipamento: ");
                    String descricaoEqpTemp = main.scanner.nextLine();
                    System.out.println("Digite a data da compra: ");
                    String dataCompraTemp = main.scanner.nextLine();
                    System.out.println("Digite o peso do equipamento: ");
                    double pesoEqpTemp = main.scanner.nextDouble();
                    System.out.println("Digite a  largura do equipamento: ");
                    double larguraEqpTemp = main.scanner.nextDouble();
                    System.out.println("Digite o comprimento do equipamento: ");
                    double comprimentoEqpTemp = main.scanner.nextDouble();
                    main.scanner.nextLine();
                    System.out.println("Digite o histórico de manutenção do equipamento: ");
                    String historicoManutencaoTemp = main.scanner.nextLine();
                    System.out.println("Digite o estado de conservação do equipamento: ");
                    String estadoConsTemp = main.scanner.nextLine();

                    Equipamento equipamento = new Equipamento(codEqpTemp, descricaoEqpTemp, dataCompraTemp, pesoEqpTemp, larguraEqpTemp, comprimentoEqpTemp, historicoManutencaoTemp, estadoConsTemp);
                    GerenciadorTrackBug.cadastrarEquipamento(equipamento);
                    break;
                case 3:
                    main.scanner.nextLine();
                    System.out.println("--- Novo emprestimo ---");
                    System.out.println("Digite a data e hora de saída: ");
                    String dataSaidaTemp = main.scanner.nextLine();
                    System.out.println("Digite a data e hora de retorno: ");
                    String dataRetornoTemp = main.scanner.nextLine();
                    System.out.println("Digite o nome do funcionario responsavel: ");
                    String funcionarioRespTemp = main.scanner.nextLine();
                    System.out.println("Observações do emprestimo: ");
                    String obsEmprestimoTemp = main.scanner.nextLine();

                    Emprestimos emprestimo = new Emprestimos(dataSaidaTemp, dataRetornoTemp, funcionarioRespTemp, obsEmprestimoTemp);
                    GerenciadorTrackBug.novoEmprestimo(emprestimo);

                    break;
                case 4:
                    GerenciadorTrackBug.listarFuncionariosCad();
                    break;
                case 5:
                    GerenciadorTrackBug.listarEquipamentosCad();
                    break;
                case 6:
                    GerenciadorTrackBug.listarEmprestimosCad();
                    break;
                case 7:
                    main.scanner.nextLine(); // Limpar buffer do input
                    System.out.println("Digite o codigo do funcionario que deseja buscar: ");
                    String codBuscaFunc = main.scanner.nextLine(); // Variavel que será buscada
                    Funcionario funcionarioEncontrado = GerenciadorTrackBug.buscarFuncionario(codBuscaFunc);

                    if (funcionarioEncontrado != null) {
                        funcionarioEncontrado.infoFuncionario();
                    } else {
                        System.out.println("Funcionario não encontrado.");
                    }
                    break;
                case 8:
                    main.scanner.nextLine(); // Limpar buffer do input
                    System.out.println("Digite o codigo do Equipamento que deseja buscar: ");
                    String codBuscaEqp = main.scanner.nextLine(); // Variavel que será buscada

                    Equipamento equipamentoEncontrado = GerenciadorTrackBug.buscarEquipamento(codBuscaEqp);
                    if (equipamentoEncontrado != null) {
                        equipamentoEncontrado.infoEquipamento();
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;
            }
            System.out.println("Deseja sair do sistema? [0]Não [1]Sim: ");
            sair = main.scanner.nextInt();

        }while(sair==0);

        main.scanner.close();
    }

}