import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEmprestimos {
    private ArrayList<Emprestimos> listaEmprestimos = new ArrayList<>(); // Criando o ArrayList de emprestimos

    // Criar novo empréstimo
    public void novoEmprestimo(Scanner scanner, GerenciadorFuncionarios gerenciadorFuncionarios, GerenciadorEquipamentos gerenciadorEquipamentos) {
        System.out.println("--- Novo empréstimo ---");
        System.out.println("Selecione o funcionário responsável: ");
        Funcionario funcResp = null;
        do {
            funcResp = gerenciadorFuncionarios.selectFuncionariosCad();
        }while (funcResp == null); // Do While para digitar um elemento valido da lista

        scanner.nextLine();

        System.out.println("Selecione o equipamento emprestado: ");
        Equipamento eqpSel = null;
        do {
            eqpSel = gerenciadorEquipamentos.selectEquipamentosCad();
        }while (eqpSel==null); // Do While para digitar um elemento valido da lista
        scanner.nextLine();

        System.out.println("Digite a data e hora de saída: ");
        String dataSaidaTemp = scanner.nextLine();
        System.out.println("Digite a data e hora de retorno: ");
        String dataRetornoTemp = scanner.nextLine();
        System.out.println("Observações: ");
        String obsEmprestimoTemp = scanner.nextLine();
        eqpSel.setDisponibilidade("indisponivel");

        Emprestimos emprestimo1 = new Emprestimos(dataSaidaTemp, dataRetornoTemp, funcResp, eqpSel, obsEmprestimoTemp); // Instanciando um emprestimo
        listaEmprestimos.add(emprestimo1); // Adicionando o objeto instanciado no ArrayList
        gerenciadorEquipamentos.adicionarEqpIndisponivel(eqpSel);
        gerenciadorEquipamentos.removeEquipamento(eqpSel);
        emprestimo1.infoEmprestimo();
        scanner.nextLine();
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

    public void devolverEquipamento(Scanner scanner, GerenciadorEquipamentos gerenciadorEquipamentos){
        if (listaEmprestimos.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há emprestimos cadastrados.");
        } else { // Se o Array possuir elementos
            int i = 0;
            for (Emprestimos empTemp : listaEmprestimos) {// For que percorre os objetos do ArrayList
                String equipamento = empTemp.getEquipamento().getDescricaoEqp(); // Get do nome do equipamento
                String responsavel = empTemp.getFuncionarioResponsavel().getNomeFuncionario(); // Get do nome do funcionario
                String observacoes = empTemp.getObservacoesEmprestimo(); // Get das observacoes
                System.out.println(i + 1 + ". Equipamento: " + equipamento + " | Responsavel: " + responsavel + " | Observação: " + observacoes);
                i++;
            }

            System.out.println("Digite o indice do emprestimo: ");
            int empEscolha = scanner.nextInt(); // indice do objeto
            empEscolha = empEscolha-1; //Pegar indice certo do Array

            Emprestimos empTemp = listaEmprestimos.get(empEscolha);
            empTemp.infoEmprestimo();
            Equipamento equipamentoEmp  = empTemp.getEquipamento(); // Armazenando o equipamento do emprestimo
            equipamentoEmp.infoEquipamento();
            equipamentoEmp.setDisponibilidade("disponivel"); // mudando a disponibilidade do equipamento
            gerenciadorEquipamentos.adicionarEqp(equipamentoEmp);
            gerenciadorEquipamentos.removeEquipamentoIndisponivel(equipamentoEmp);
            listaEmprestimos.remove(empEscolha); //remove o emprestimo do ArrayList
        }
    }
}
