public class Main {
    public static void main(String[] args) {

     Funcionario funcionario1 = new Funcionario("4134", "Otavio costa de Oliveira", "Atendente", "10/05/2020");
     funcionario1.infoFuncionario();

     Equipamento equipamento1 = new Equipamento("093812", "Parafusadeira eletrica", "27/08/2024", 3.6, 5, 10, "Nenhuma manutenção realizada", "Novo");
     equipamento1.infoEquipamento();
    }
}