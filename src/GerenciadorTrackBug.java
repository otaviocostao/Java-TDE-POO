import java.util.ArrayList;

public class GerenciadorTrackBug {
    static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    static ArrayList<Equipamento> listaEquipamentos = new ArrayList<>();
    static ArrayList<Emprestimos> listaEmprestimentos = new ArrayList<>();

    // Função para cadastrar funcionario
    static public void cadastrarFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
    }

    // Função para cadastrar novo equipamento
    static public void cadastrarEquipamento(Equipamento equipamento){
        listaEquipamentos.add(equipamento);
    }

    // Função para cadastrar novo emprestimo de equipamento
    static public void novoEmprestimo(Emprestimos emprestimo){
        listaEmprestimentos.add(emprestimo);
    }


    //Função para listar os funcionarios cadastrados
    static public void listarFuncionariosCad(){
        if (!listaFuncionarios.isEmpty()){
            for (Funcionario funcTemp:listaFuncionarios){
                funcTemp.infoFuncionario();
            }
        }else{
            System.out.println("Não foi cadastrado nenhum funcionario cadastrado");
        }
    }

    // Função para listar os equipamento cadastrados
    static public void listarEquipamentosCad(){
        if (!listaEquipamentos.isEmpty()){
            for (Equipamento eqpTemp:listaEquipamentos){
                eqpTemp.infoEquipamento();
            }
        }else{
            System.out.println("Não foi cadastrado nenhum equipamento.");
        }
    }

    //Função para listar os emprestimos cadastrados
    static public void listarEmprestimosCad(){
        if (!listaEmprestimentos.isEmpty()){
            for (Emprestimos empTemp:listaEmprestimentos){
                empTemp.infoEmprestimo();
            }
        }else{
            System.out.println("Não foi cadastrado nenhum emprestimo.");
        }
    }


    //Função para buscar funcionario pelo codFuncionario
    static public Funcionario buscarFuncionario(String codFuncionario){
       if (!listaFuncionarios.isEmpty()){
           for(Funcionario funcTemp:listaFuncionarios){
               if (funcTemp.getCodFuncionario().equals(codFuncionario)){
                   return funcTemp;
               }
           }
       }else{
           System.out.println("Não foi cadastrado nenhum funcionario cadastrado");
       }
       return null;
    }


    //Função para buscar equipamento
    static public Equipamento buscarEquipamento(String codBusca){
        if (!listaEquipamentos.isEmpty()){
            for (Equipamento eqpTemp:listaEquipamentos){
                if (eqpTemp.getCodEquipamento().equals(codBusca)){
                    return eqpTemp;
                }
            }
        }else{
            System.out.println("Não foi cadastrado nenhum equipamento.");
        }
        return null;
    }


    // Função para exibir informações do menu;
    static public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("[1] - Cadastrar novo funcionário");
        System.out.println("[2] - Cadastrar novo equipamento");
        System.out.println("[3] - Cadastrar novo emprestimo");
        System.out.println("[4] - Listar funcionários cadastrados");
        System.out.println("[5] - Listar equipamentos cadastrados");
        System.out.println("[6] - Listar emprestimos de equipamentos");
        System.out.println("[7] - Buscar funcionario pelo código");
        System.out.println("[8] - Buscar equipamento pelo código");
        System.out.println("Digite a opção desejada:");
    }

}
