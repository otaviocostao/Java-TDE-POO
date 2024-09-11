import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEmprestimos {
    private ArrayList<Emprestimos> listaEmprestimos = new ArrayList<>(); // Criando o ArrayList de emprestimos

    // Criar novo empréstimo
    public void novoEmprestimo(Scanner scanner) {
        System.out.println("--- Novo empréstimo ---");
        System.out.println("Digite a data e hora de saída: ");
        String dataSaidaTemp = scanner.nextLine();
        System.out.println("Digite a data e hora de retorno: ");
        String dataRetornoTemp = scanner.nextLine();
        System.out.println("Digite o nome do funcionário responsável: ");
        String funcionarioRespTemp = scanner.nextLine();
        System.out.println("Observações: ");
        String obsEmprestimoTemp = scanner.nextLine();

        Emprestimos emprestimo1 = new Emprestimos(dataSaidaTemp, dataRetornoTemp, funcionarioRespTemp, obsEmprestimoTemp); // Instanciando um emprestimo
        listaEmprestimos.add(emprestimo1); // Adicionando o objeto instanciado no ArrayList
    }

    // Listar todos os empréstimos cadastrados
    public void listarEmprestimosCad() {
        if (listaEmprestimos.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há empréstimos cadastrados.");
        } else {
            for (Emprestimos empTemp : listaEmprestimos) { // For que percorre os objetos do ArrayList
                empTemp.infoEmprestimo(); //Metodo de Emprestimos para exibir as informações
            }
        }
    }
}
