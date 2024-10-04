import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Emprestimos {

    // Declaração de variáveis privadas
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraRetorno;
    private Funcionario funcionarioResponsavel;
    private Equipamento equipamento;
    private String observacoesEmprestimo;

    // Método construtor de emprestimos
    public Emprestimos(String dataHoraSaida, String dataHoraRetorno, Funcionario funcionarioResponsavel, Equipamento equipamento, String observacoesEmprestimo) {
        setDataHoraSaida(dataHoraSaida); // Usar o setter para conversão
        setDataHoraRetorno(dataHoraRetorno); // Usar o setter para conversão
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.equipamento = equipamento;
        this.observacoesEmprestimo = observacoesEmprestimo;
    }

    // Métodos setters
    public void setDataHoraSaida(String dataHoraSaida) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.dataHoraSaida = LocalDateTime.parse(dataHoraSaida, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data e hora de saída inválida: " + dataHoraSaida);
            this.dataHoraSaida = null; // Ou atribuir um valor padrão
        }
    }

    public void setDataHoraRetorno(String dataHoraRetorno) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.dataHoraRetorno = LocalDateTime.parse(dataHoraRetorno, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data e hora de retorno inválida: " + dataHoraRetorno);
            this.dataHoraRetorno = null; // Ou atribuir um valor padrão
        }
    }

    public void setObservacoesEmprestimo(String observacoesEmprestimo) {
        this.observacoesEmprestimo = observacoesEmprestimo;
    }

    // Métodos Getters
    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public LocalDateTime getDataHoraRetorno() {
        return dataHoraRetorno;
    }

    public String getObservacoesEmprestimo() {
        return observacoesEmprestimo;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    // Método para exibir informações do emprestimo
    public void infoEmprestimo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("--- Informações do empréstimo ---");
        System.out.println("Funcionário responsável: " + this.funcionarioResponsavel.getNomeFuncionario());
        System.out.println("Equipamento: " + this.equipamento.getDescricaoEqp());
        System.out.println("Data e hora de saída: " + (this.dataHoraSaida != null ? this.dataHoraSaida.format(formatter) : "Data inválida inserida"));
        System.out.println("Data e hora de retorno: " + (this.dataHoraRetorno != null ? this.dataHoraRetorno.format(formatter) : "Data inválida inserida"));
        System.out.println("Observações do empréstimo: " + this.observacoesEmprestimo + "\n");
    }
}
