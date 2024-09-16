public class Emprestimos {

    // Declaração de variaveis privadas
    // Elas só podem ser acessadas dentro da classe
    private String dataHoraSaida;
    private String dataHoraRetorno;
    private String funcionarioResponsavel;
    private String observacoesEmprestimo;

    // Metodo construtor de emprestimos
    public Emprestimos(String dataHoraSaida, String dataHoraRetorno, String funcionarioResponsavel, String observacoesEmprestimo){
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraRetorno = dataHoraRetorno;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.observacoesEmprestimo = observacoesEmprestimo;
    }

    // Metodos setters
    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public void setDataHoraRetorno(String dataHoraRetorno) {
        this.dataHoraRetorno = dataHoraRetorno;
    }

    public void setFuncionarioResponsavel(String funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public void setObservacoesEmprestimo(String observacoesEmprestimo) {
        this.observacoesEmprestimo = observacoesEmprestimo;
    }

    // Metodos Getters
    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public String getDataHoraRetorno() {
        return dataHoraRetorno;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public String getObservacoesEmprestimo() {
        return observacoesEmprestimo;
    }

    // Metodo para exibir informações do emprestimo
    public void infoEmprestimo(){
        System.out.println("--- Informações do emprestimo ---");
        System.out.println("Data e hora de saída: " + this.dataHoraSaida);
        System.out.println("Data e hora de retorno: " + this.dataHoraRetorno);
        System.out.println("Funcionario responsável: " + this.funcionarioResponsavel);
        System.out.println("Observações do emprestimo: " + this.observacoesEmprestimo+ "\n");
    }
}
