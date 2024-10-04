import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Funcionario {

    // Declaração de variáveis privadas
    private String codFuncionario;
    private String nomeFuncionario;
    private String funcaoFuncionario;
    private LocalDate dataAdmissaoFuncionario;

    // Método construtor da classe Funcionario
    public Funcionario(String codFuncionario, String nomeFuncionario, String funcaoFuncionario, String dataAdmissaoFuncionario) {
        this.codFuncionario = codFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.funcaoFuncionario = funcaoFuncionario;
        setDataAdmissaoFuncionario(dataAdmissaoFuncionario); // Usar o setter para a data
    }

    // Métodos Setters
    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    public void setDataAdmissaoFuncionario(String dataAdmissaoFuncionario) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // ou outro formato desejado
            this.dataAdmissaoFuncionario = LocalDate.parse(dataAdmissaoFuncionario, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + dataAdmissaoFuncionario);
            this.dataAdmissaoFuncionario = null; // Ou atribuir uma data padrão
        }
    }

    // Métodos Getters
    public String getCodFuncionario() {
        return codFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public LocalDate getDataAdmissaoFuncionario() {
        return dataAdmissaoFuncionario;
    }

    // Método para exibir informações do funcionário
    public void infoFuncionario() {
        System.out.println("--- Informações do funcionário ---");
        System.out.println("Código: " + this.codFuncionario);
        System.out.println("Nome: " + this.nomeFuncionario);
        System.out.println("Função: " + this.funcaoFuncionario);
        System.out.println("Data de admissão: " + (this.dataAdmissaoFuncionario != null ? this.dataAdmissaoFuncionario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Data inválida inserida") + "\n");
    }
}
