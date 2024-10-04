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
        Equipamento eqpSel = null; // instanciando o objeto como null
        do {
            eqpSel = gerenciadorEquipamentos.selectEquipamentosCad(); // Metodo que exibe as opções de equipamentos cadastrados
        }while (eqpSel==null); // Do While para digitar um elemento valido da lista
        scanner.nextLine();

        System.out.println("Digite a data e hora de saída (dd/mm/aaaa HH:mm): ");
        String dataSaidaTemp = scanner.nextLine();
        System.out.println("Digite a data e hora de retorno prevista (dd/mm/aaaa HH:mm): ");
        String dataRetornoTemp = scanner.nextLine();
        System.out.println("Observações: ");
        String obsEmprestimoTemp = scanner.nextLine();
        eqpSel.setDisponibilidade("indisponivel");
        System.out.println("\n");

        Emprestimos emprestimo1 = new Emprestimos(dataSaidaTemp, dataRetornoTemp, funcResp, eqpSel, obsEmprestimoTemp); // Instanciando um emprestimo
        listaEmprestimos.add(emprestimo1); // Adicionando o objeto instanciado no ArrayList
        gerenciadorEquipamentos.adicionarEqpIndisponivel(eqpSel); // Adiciona o equipamento ao Array de Equipamentos indisponiveis
        gerenciadorEquipamentos.removeEquipamento(eqpSel); // Removendo o elemento do Array de Equipamentos disponiveis
        emprestimo1.infoEmprestimo(); // Informações do emprestimo gerado
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

    // Metodo para devolver o equipamento emprestado e excluir o emprestimo do array
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

            Emprestimos empTemp = listaEmprestimos.get(empEscolha); // Instanciando o emprestimo
            Equipamento equipamentoEmp  = empTemp.getEquipamento(); // Instanciando o equipamento do emprestimo
            System.out.println("Equipamento "+ equipamentoEmp.getDescricaoEqp() + " devolvido"); 
            equipamentoEmp.setDisponibilidade("disponivel"); // mudando a disponibilidade do equipamento para disponivel
            gerenciadorEquipamentos.adicionarEqp(equipamentoEmp); // Adicionando o equipamento de volta ao Array de equipamentos disponiveis
            gerenciadorEquipamentos.removeEquipamentoIndisponivel(equipamentoEmp); // Removendo o equipamento do Array de equipamentos indisponiveis
            listaEmprestimos.remove(empEscolha); //remove o emprestimo do ArrayList de emprestimos
        }
    }
}
