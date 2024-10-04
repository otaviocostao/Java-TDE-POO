import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>(); // Criando o ArrayList de funcionarios
    Scanner scanner1 = new Scanner(System.in);

    // Cadastrar novo funcionário
    public void cadastrarFuncionario(Scanner scanner) {
        System.out.println("--- Cadastrar novo funcionario ---");
        String codFuncionarioTemp;
        do { // Do While para repetir o input do código para não repetir o mesmo código já cadastrado
            System.out.println("Digite o código do funcionário: ");
            codFuncionarioTemp = scanner.nextLine();
            if (verificaCodFuncionario(codFuncionarioTemp)) { // Verifica se o código já foi cadastrado
                System.out.println("Este código já está cadastrado. Por favor, tente outro.");
            }
        } while (verificaCodFuncionario(codFuncionarioTemp)); // Verifica se o código já foi cadastrado

        System.out.println("Digite o nome do funcionário: ");
        String nomeFuncionarioTemp = scanner.nextLine();
        System.out.println("Digite a função do funcionário: ");
        String funcaoFuncionarioTemp = scanner.nextLine();
        System.out.println("Digite a data de admissão (dd/mm/aaaa): ");
        String dataAdmissaoTemp = scanner.nextLine();

        // Instanciando Funcionario com as variaveis que receberam elementos do input
        Funcionario funcionario1 = new Funcionario(codFuncionarioTemp, nomeFuncionarioTemp, funcaoFuncionarioTemp, dataAdmissaoTemp);
        listaFuncionarios.add(funcionario1); // Adicionando o objeto instanciado no ArrayList de funcionarios
    }

    // Verificar se o código de funcionário já existe
    public boolean verificaCodFuncionario(String codFuncionario) {
        for (Funcionario funcTemp : listaFuncionarios) { // For que percorre os objetos do ArrayList
            if (funcTemp.getCodFuncionario().equals(codFuncionario)) { // Verifica se o código buscado é o mesmo do elemento
                return true; // Retorna True se encontrado
            }
        }
        return false; // Retorna False se não encontrado
    }

    // Buscar funcionário pelo código
    public Funcionario buscarFuncionario(String codFuncionario) {
        for (Funcionario funcTemp : listaFuncionarios) { // For que percorre os objetos do ArrayList
            if (funcTemp.getCodFuncionario().equals(codFuncionario)) { // Verifica se o código buscado é o mesmo do elemento
                return funcTemp; // Retorna o objeto encontrado
            }
        }

        return null; // Retorna Null se não encontrado
    }

    // Listar todos os funcionários cadastrados
    public void listarFuncionariosCad() {
        if (listaFuncionarios.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há funcionários cadastrados.");
        } else { // Se o Array possuir elementos
            for (Funcionario funcTemp : listaFuncionarios) { // For que percorre os objetos do ArrayList
                funcTemp.infoFuncionario(); // Função para exibir os dados do objeto
            }
        }
    }

    public Funcionario selectFuncionariosCad() {
        if (listaFuncionarios.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há funcionários cadastrados.");
        } else { // Se o Array possuir elementos
            int i=0;
            for (Funcionario funcTemp : listaFuncionarios) { // For que percorre os objetos do ArrayList
                String nomeTemp = funcTemp.getNomeFuncionario(); // Função para exibir os dados do objeto
                String codTemp = funcTemp.getCodFuncionario();
                    System.out.println("COD: " + codTemp + " | Nome: "+ nomeTemp);
                i++;
            }
            System.out.println("Digite o codigo desejado: ");
            String funcCod = scanner1.nextLine();

            Funcionario funcTemp = buscarFuncionario(funcCod);
            return funcTemp;
        }
        return null;
    }

    // Metodo publico que verifica se o array está vazio, pois o array é private
    public boolean verListaVazia(){
        if (listaFuncionarios.isEmpty()){ // if para checar o array com isEmpty
            return true;
        }else {
            return false;
        }
    }

    // Metodo para excluir funcionario da Lista
    public void excluirFuncionario(){
        Funcionario funcionario = null;
            if (verListaVazia()) { // Verifica se  o Array está vazio
                System.out.println("Não há funcionários cadastrados.");
            } else { // Se o Array possuir elementos
                do {
                    for (Funcionario funcTemp : listaFuncionarios) { // For que percorre os objetos do ArrayList
                        String nomeTemp = funcTemp.getNomeFuncionario(); // Função para exibir os dados do objeto
                        String codTemp = funcTemp.getCodFuncionario();
                        System.out.println("COD: " + codTemp + " | Nome: "+ nomeTemp );
                    }
                    System.out.println("Digite o codigo desejado: ");
                    String funcSel = scanner1.nextLine();
                    funcionario = buscarFuncionario(funcSel);
                }while(funcionario==null);
                System.out.println("O funcionario " + funcionario.getNomeFuncionario() + " foi removido da lista de funcionarios");
                listaFuncionarios.remove(funcionario);
        }
    }
}