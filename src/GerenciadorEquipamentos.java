import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEquipamentos {
    private ArrayList<Equipamento> listaEquipamentos = new ArrayList<>(); //Criando o ArrayList de equipamentos
    Scanner scanner1 = new Scanner(System.in);
    // Cadastrar novo equipamento
    public void cadastrarEquipamento(Scanner scanner) {
        System.out.println("--- Cadastrar novo equipamento ---");
        String codEqpTemp;
        do { // Do While para repetir o input do código para não repetir o mesmo código já cadastrado
            System.out.println("Digite o código do equipamento: ");
            codEqpTemp = scanner.nextLine();
            if (verificaCodEquipamento(codEqpTemp)) { // Verifica se o código já foi cadastrado
                System.out.println("Este código já está cadastrado. Por favor, tente outro.");
            }
        } while (verificaCodEquipamento(codEqpTemp)); // Verifica se o código já foi cadastrado

        System.out.println("Digite a descrição do equipamento: ");
        String descricaoEqpTemp = scanner.nextLine();
        System.out.println("Digite a data da compra: ");
        String dataCompraTemp = scanner.nextLine();
        System.out.println("Digite o peso do equipamento: ");
        double pesoEqpTemp = scanner.nextDouble();
        System.out.println("Digite a largura do equipamento: ");
        double larguraEqpTemp = scanner.nextDouble();
        System.out.println("Digite o comprimento do equipamento: ");
        double comprimentoEqpTemp = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o histórico de manutenção: ");
        String historicoManutencaoTemp = scanner.nextLine();
        System.out.println("Digite o estado de conservação: ");
        String estadoConsTemp = scanner.nextLine();

        // Instanciando Equipamento com as variaveis que receberam elementos do input
        Equipamento equipamento1 = new Equipamento(codEqpTemp, descricaoEqpTemp, dataCompraTemp, pesoEqpTemp, larguraEqpTemp, comprimentoEqpTemp, historicoManutencaoTemp, estadoConsTemp);
        listaEquipamentos.add(equipamento1); // Adicionando o objeto instanciado no ArrayList de equipamentos
    }

    // Verificar se o código do equipamento já existe
    public boolean verificaCodEquipamento(String codEquipamento) {
        for (Equipamento eqpTemp : listaEquipamentos) { // For que percorre os objetos do ArrayList
            if (eqpTemp.getCodEquipamento().equals(codEquipamento)) { // Verifica se o código buscado é o mesmo do elemento
                return true; // Retorna True se encontrado
            }
        }
        return false; // Retorna False se não encontrado
    }

    // Buscar equipamento pelo código
    public Equipamento buscarEquipamento(String codBusca) {
        for (Equipamento eqpTemp : listaEquipamentos) {  // For que percorre os objetos do ArrayList
            if (eqpTemp.getCodEquipamento().equals(codBusca)) { // Verifica se o código buscado é o mesmo do elemento
                return eqpTemp; // Retorna o objeto encontrado
            }
        }

        return null; // Retorna Null se não encontrado
    }

    // Listar todos os equipamentos cadastrados
    public void listarEquipamentosCad() {
        if (listaEquipamentos.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há equipamentos cadastrados.");
        } else {
            for (Equipamento eqpTemp : listaEquipamentos) { // For que percorre os objetos do ArrayList
                eqpTemp.infoEquipamento(); // Função para exibir os dados do objeto
            }
        }
    }


    public Equipamento selectEquipamentosCad() {
        if (listaEquipamentos.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há equipamentos cadastrados.");
        } else { // Se o Array possuir elementos
            int i=0;
            for (Equipamento eqpTemp : listaEquipamentos) { // For que percorre os objetos do ArrayList
                String nomeTemp = eqpTemp.getDescricaoEqp(); // Função para exibir os dados do objeto
                String codTemp = eqpTemp.getCodEquipamento();
                System.out.println(i+1 + ". "+ nomeTemp + "COD: " + codTemp );
                i++;
            }
            System.out.println("Digite o codigo desejado: ");
            String codEscolha = scanner1.nextLine();

            return buscarEquipamento(codEscolha);
        }
        return null;
    }
}
