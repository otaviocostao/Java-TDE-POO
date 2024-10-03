import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEquipamentos {
    private ArrayList<Equipamento> listaEquipamentos = new ArrayList<>(); //Criando o ArrayList de equipamentos
    private ArrayList<Equipamento> equipamentosIndisponiveis = new ArrayList<>(); // ArrayList para os equipamentos indisponiveis
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

    public void adicionarEqp(Equipamento equipamento){
        listaEquipamentos.add(equipamento);
    }

    public void removeEquipamento(Equipamento equipamento) {
        listaEquipamentos.remove(equipamento);
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
        if (listaEquipamentos.isEmpty() && equipamentosIndisponiveis.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há equipamentos cadastrados.");
        } else {
            System.out.println("Equipamentos disponiveis:\n");
            for (Equipamento eqpTemp : listaEquipamentos) { // For que percorre os objetos do ArrayList
                eqpTemp.infoEquipamento(); // Função para exibir os dados do objeto
            }
            System.out.println("\nEquipamentos indisponiveis:\n");
            for (Equipamento eqpTemp : equipamentosIndisponiveis){
                eqpTemp.infoEquipamento();
            }
        }
    }

    public Equipamento selectEquipamentosCad() {
        if (listaEquipamentos.isEmpty()) { // Verifica se  o Array está vazio
            System.out.println("Não há equipamentos cadastrados.");
        } else { // Se o Array possuir elementos
            for (Equipamento eqpTemp : listaEquipamentos) {// For que percorre os objetos do ArrayList
                if (eqpTemp.getDisponibilidade().equals("disponivel")){
                    String descTemp = eqpTemp.getDescricaoEqp(); // Função para exibir os dados do objeto
                    String codTemp = eqpTemp.getCodEquipamento();
                    System.out.println("COD: " + codTemp + " | Descricao: "+ descTemp );
                }
            }

            System.out.println("Digite o código do equipamento desejado: ");
            String eqpEscolha = scanner1.nextLine();
            return buscarEquipamento(eqpEscolha);
        }
        return null;
    }

    // Metodo publico que verifica se o array está vazio, pois o array é private
    public boolean verListaVazia(){
        if (listaEquipamentos.isEmpty()){ // if para checar o array com isEmpty
            return true;
        }else {
            return false;
        }
    }


    public void excluirEquipamento(){
        Equipamento equipamento = null;
            if (verListaVazia()) { // Verifica se  o Array está vazio
                System.out.println("Não há equipamentos cadastrados.");
            } else { // Se o Array possuir elementos
                do {
                    for (Equipamento eqpTemp : listaEquipamentos) { // For que percorre os objetos do ArrayList
                        String descTemp = eqpTemp.getDescricaoEqp(); // Função para exibir os dados do objeto
                        String codTemp = eqpTemp.getCodEquipamento();
                        System.out.println("COD: " + codTemp + " | Descricao: "+ descTemp );
                    }

                    System.out.println("Digite o código do equipamento que deseja remover: ");
                    String eqpCod = scanner1.nextLine();
                    equipamento = buscarEquipamento(eqpCod);
                }while(equipamento == null);
                System.out.println("O equipamento " + equipamento.getDescricaoEqp() + " foi removido da lista de equipamentos");
                listaEquipamentos.remove(equipamento);
            }
    }

    public void adicionarEqpIndisponivel(Equipamento equipamento){

        equipamentosIndisponiveis.add(equipamento);
    }


    public void removeEquipamentoIndisponivel(Equipamento equipamento){

        equipamentosIndisponiveis.removeIf(eq -> eq.getCodEquipamento().equals(equipamento.getCodEquipamento()));
    }
}
