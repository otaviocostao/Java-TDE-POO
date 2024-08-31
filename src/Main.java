import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    ArrayList<Equipamento> listaEquipamentos = new ArrayList<>();
    ArrayList<Emprestimos> listaEmprestimentos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int sair = 0;
        int opcao;
        do {
            main.menu();
            opcao = main.scanner.nextInt();
            switch (opcao){
                case 1:
                    main.cadastrarFuncionario();
                    break;
                case 2:
                    main.cadastrarEquipamento();
                    break;
                case 3:
                    main.novoEmprestimo();
                    break;
                case 4:
                    main.listarFunciariosCad();
                    break;
                case 5:
                    main.listarEquipamentosCad();
                    break;
                case 6:
                    main.listarEmprestimosCad();
                    break;
                case 7:
                    break;
            }
            System.out.println("Deseja sair do sistema? [0]Não [1]Sim: ");
            sair = main.scanner.nextInt();

        }while(sair==0);

        main.scanner.close();
    }


    public void cadastrarFuncionario(){
        scanner.nextLine();
        System.out.println("--- Cadastrar novo funcionario ---");
        System.out.println("Digite o código do funcionario: ");
        String codFuncionarioTemp = scanner.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        String nomeFuncionarioTemp = scanner.nextLine();
        System.out.println("Digite a função do funcionáro: ");
        String funcaoFuncionarioTemp = scanner.nextLine();
        System.out.println("Digite a data de admissão: ");
        String dataAdmissaoTemp = scanner.nextLine();

        listaFuncionarios.add(new Funcionario(codFuncionarioTemp, nomeFuncionarioTemp, funcaoFuncionarioTemp, dataAdmissaoTemp));
    }

    public void cadastrarEquipamento(){
        scanner.nextLine();
        System.out.println("--- Cadastrar equipamento ---");
        System.out.println("Digite o código do equipamento: ");
        String codEqpTemp = scanner.nextLine();
        System.out.println("Digite a descrição do equipamento: ");
        String descricaoEqpTemp = scanner.nextLine();
        System.out.println("Digite a data da compra: ");
        String dataCompraTemp = scanner.nextLine();
        System.out.println("Digite o peso do equipamento: ");
        double pesoEqpTemp = scanner.nextDouble();
        System.out.println("Digite a  largura do equipamento: ");
        double larguraEqpTemp = scanner.nextDouble();
        System.out.println("Digite o comprimento do equipamento: ");
        double comprimentoEqpTemp = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o histórico de manutenção do equipamento: ");
        String historicoManutencaoTemp = scanner.nextLine();
        System.out.println("Digite o estado de conservação do equipamento: ");
        String estadoConsTemp = scanner.nextLine();

        listaEquipamentos.add(new Equipamento(codEqpTemp, descricaoEqpTemp, dataCompraTemp, pesoEqpTemp, larguraEqpTemp, comprimentoEqpTemp, historicoManutencaoTemp, estadoConsTemp));

    }

    public void novoEmprestimo(){
        scanner.nextLine();
        System.out.println("--- Novo emprestimo ---");
        System.out.println("Digite a data e hora de saída: ");
        String dataSaidaTemp = scanner.nextLine();
        System.out.println("Digite a data e hora de retorno: ");
        String dataRetornoTemp = scanner.nextLine();
        System.out.println("Digite o nome do funcionario responsavel: ");
        String funcionarioRespTemp = scanner.nextLine();
        System.out.println("Observações do emprestimo: ");
        String obsEmprestimoTemp = scanner.nextLine();

        listaEmprestimentos.add(new Emprestimos(dataSaidaTemp, dataRetornoTemp, funcionarioRespTemp, obsEmprestimoTemp));
    }

    public void listarFunciariosCad(){
        int indexFinalFunc = listaFuncionarios.size() - 1;

        if (indexFinalFunc==-1){
            System.out.println("Não foi cadastrado nenhum funcionário.");
        }else{
            for(int i=0; i<=indexFinalFunc; i++){
                listaFuncionarios.get(i).infoFuncionario();
            }
        }
    }


    public void listarEquipamentosCad(){
        int indexFinalEqp = listaEquipamentos.size() - 1;

        if (indexFinalEqp<0){
            System.out.println("Não foi cadastrado nenhum equipamento.");
        }else{
            for(int i=0; i<=indexFinalEqp; i++){
                listaEquipamentos.get(i).infoEquipamento();
            }
        }
    }


    public void listarEmprestimosCad(){
        int indexFinalEmp = listaEmprestimentos.size() - 1;

        if (indexFinalEmp<0){
            System.out.println("Não foi cadastrado nenhum emprestimo.");
        }else{
            for(int i=0; i<=indexFinalEmp; i++){
                listaEmprestimentos.get(i).infoEmprestimo();
            }
        }
    }

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("[1] - Cadastrar novo funcionário");
        System.out.println("[2] - Cadastrar novo equipamento");
        System.out.println("[3] - Cadastrar novo emprestimo");
        System.out.println("[4] - Listar funcionários cadastrados");
        System.out.println("[5] - Listar equipamentos cadastrados");
        System.out.println("[6] - Listar emprestimos de equipamentos");
        System.out.println("[7] - Sair");
        System.out.println("Digite a opção desejada:");
    }
}