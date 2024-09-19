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
        System.out.println("Digite a data de admissão: ");
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
                System.out.println(i+1 + ". "+ nomeTemp + "COD: " + codTemp );
                i++;
            }
            System.out.println("Digite o codigo desejado: ");
            String codEscolha = scanner1.nextLine();

            return buscarFuncionario(codEscolha);
        }
        return null;
    }
}