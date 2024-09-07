import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTrackBug {
    ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    ArrayList<Equipamento> listaEquipamentos = new ArrayList<>();
    ArrayList<Emprestimos> listaEmprestimentos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // Função para cadastrar funcionario
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
}
