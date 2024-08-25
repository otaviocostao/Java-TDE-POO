import java.sql.Struct;

public class Emprestimos {
    private String dataHoraSaida;
    private String dataHoraRetorno;
    private String funcionarioResponsavel;
    private String observacoesEmprestimo;

    public Emprestimos(String dataHoraSaida, String dataHoraRetorno, String funcionarioResponsavel, String observacoesEmprestimo){
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraRetorno = dataHoraRetorno;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.observacoesEmprestimo = observacoesEmprestimo;
    }
}
